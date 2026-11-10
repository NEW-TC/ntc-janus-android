package org.linhome.store

import org.linhome.entities.Account
import org.linhome.push.NtcPush
import org.linphone.core.Core
import org.linphone.core.TransportType
import org.linphone.core.tools.Log

/**
 * Настройка push-прокси из XML удалённой настройки (ссылка или QR), секция:
 *   [ntc_account]
 *   proxy=sips:push.new-tc.ru:5061   (формат как в поле «Прокси»)
 *   transport=tls                    (udp | tcp | tls)
 *   expires=86400                    (необязательно; по умолчанию 86400 — срок регистрации push-режима)
 * Если секции нет, аккаунт остаётся таким, как его создало ядро из proxy_0 (прямая регистрация, без push).
 * Домен аккаунта (identity) не меняется, соединение идёт на proxy. Секция после импорта удаляется.
 */
object AccountImporter {

    private const val SECTION = "ntc_account"

    fun applyFrom(core: Core): Boolean {
        val config = core.config
        if (config.hasSection(SECTION) == 0) return false
        val proxy = config.getString(SECTION, "proxy", null)?.trim()
        val transport = when (config.getString(SECTION, "transport", null)?.trim()?.lowercase()) {
            "udp" -> TransportType.Udp
            "tcp" -> TransportType.Tcp
            "tls" -> TransportType.Tls
            else -> null
        }
        val expires = config.getString(SECTION, "expires", null)?.trim()?.toIntOrNull()?.takeIf { it > 0 } ?: NtcPush.PUSH_EXPIRES
        config.cleanSection(SECTION)
        if (proxy.isNullOrEmpty()) return false

        return try {
            val server = core.createAddress(Account.normalizeProxy(proxy, transport)) ?: return false
            val serverText = server.asStringUriOnly().let { base ->
                // asStringUriOnly() отдаёт параметры URI (transport=...) вместе с адресом
                base
            }
            // На момент удалённой настройки аккаунты ядра ещё не созданы из конфигурации: правим сам конфиг.
            config.sectionsNamesList.filter { it.startsWith("proxy_") }.forEach { section ->
                config.setString(section, "reg_proxy", serverText)
                config.setInt(section, "push_notification_allowed", 1)
                config.setInt(section, "reg_expires", expires)
            }
            // Если аккаунты уже есть (повторная настройка), правим и их
            core.accountList.forEach { account ->
                val params = account.params.clone()
                params.serverAddress = server
                params.pushNotificationAllowed = true
                params.expires = expires
                account.setParams(params)
            }
            removeStaleAuthSections(config)
            config.sync()
            Log.i("[Account Importer] Адрес сервера регистрации: $serverText")
            true
        } catch (e: Exception) {
            Log.e("[Account Importer] Не удалось применить $SECTION: $e")
            false
        }
    }

    /** Старые auth_info с тем же username (кроме auth_info_0 из текущей настройки) удаляем: иначе SDK подпишет старым Auth ID (403). */
    private fun removeStaleAuthSections(config: org.linphone.core.Config) {
        val current = config.getString("auth_info_0", "username", null) ?: return
        config.sectionsNamesList
            .filter { it.startsWith("auth_info_") && it != "auth_info_0" }
            .filter { config.getString(it, "username", null) == current }
            .forEach { config.cleanSection(it) }
    }
}
