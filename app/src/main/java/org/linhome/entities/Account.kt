/*
 * Copyright (c) 2010-2020 Belledonne Communications SARL.
 *
 * This file is part of linhome-android
 * (see https://www.linhome.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.linhome.entities

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import org.linhome.LinhomeApplication
import org.linhome.push.NtcPush
import org.linhome.LinhomeApplication.Companion.coreContext
import org.linhome.LinhomeApplication.Companion.corePreferences
import org.linhome.linphonecore.CorePreferences
import org.linphone.core.*
import org.linphone.core.tools.Log

object Account {

    private const val PUSH_GW_ID_KEY = "linhome_pushgateway"

    fun configured(): Boolean {
        return coreContext.core.proxyConfigList.isNotEmpty()
    }

    fun get(): ProxyConfig? {
        coreContext.core.proxyConfigList.forEach {
            if (PUSH_GW_ID_KEY != it.idkey)
                return it
        }
        return null
    }

    fun linhomeAccountCreateProxyConfig(accountCreator: AccountCreator) {
        accountCreator.createProxyConfig()?.let { proxyConfig ->
            proxyConfig.findAuthInfo()?.algorithm = corePreferences.passwordAlgo
            proxyConfig.isPushNotificationAllowed = true
        }
    }

    fun sipAccountLogin(
        accountCreator: AccountCreator,
        proxy: String?,
        expiration: String,
        authId: String,
        pushReady: MutableLiveData<Boolean>
    ) {
        // Аккаунт создаём напрямую через Account API: у AccountCreator/ProxyConfig маршрут (outbound proxy) не применяется.
        val core = coreContext.core
        val username = accountCreator.username ?: return
        val domain = accountCreator.domain ?: return
        val identity = core.createAddress("sip:$username@$domain") ?: return
        val transport = accountCreator.transport ?: TransportType.Udp
        // В Linphone SDK 5.4 соединение идёт на serverAddress, а маршрут (outbound proxy) задать отдельно нельзя
        // (включение outbound proxy сбрасывает маршруты на serverAddress). Поэтому «Прокси» становится адресом сервера
        // регистрации, а домен аккаунта (identity) остаётся прежним.
        val serverText = if (!TextUtils.isEmpty(proxy)) normalizeProxy(proxy!!, transport)
                         else "sip:$domain;transport=${transport.name.lowercase()}"
        val server = core.createAddress(serverText) ?: return
        val params = core.createAccountParams()
        params.identityAddress = identity
        params.serverAddress = server
        params.isRegisterEnabled = true
        params.pushNotificationAllowed = true
        params.expires = expiration.toInt()
        // Старые auth_info с тем же username (например, с прежним Auth ID) SDK подставляет в ответ на запрос
        // авторизации по паре username+realm и получает 403 — удаляем их перед созданием.
        removeAuthInfos(username)
        // Auth ID (userid) отличается от SIP ID (username) на нашей ВАТС.
        core.addAuthInfo(
            Factory.instance().createAuthInfo(username, authId, accountCreator.password, null, null, domain)
        )
        val account = core.createAccount(params)
        core.addAccount(account)
        core.defaultAccount = account
        Log.i("[NtcLogin] identity=${identity.asStringUriOnly()} server=${server.asStringUriOnly()}")
        NtcPush.applyStoredToken()
        pushReady.value = true
    }

    /**
     * "host", "host:порт", "sip:host:порт", "sips:host:порт" (+ ";transport=tcp|tls|udp") -> "sip:host:порт;transport=...".
     * Транспорт: sips: означает TLS, затем параметр ;transport=, иначе выбранный в форме.
     */
    fun normalizeProxy(input: String, selected: TransportType?): String {
        var value = input.trim()
        var transport = selected ?: TransportType.Udp
        val sips = value.startsWith("sips:", ignoreCase = true)
        value = value.replace(Regex("^(?i)sips?:"), "")
        val params = value.substringAfter(';', "")
        value = value.substringBefore(';')
        Regex("(?i)transport=(udp|tcp|tls)").find(params)?.let {
            transport = when (it.groupValues[1].lowercase()) {
                "tcp" -> TransportType.Tcp
                "tls" -> TransportType.Tls
                else -> TransportType.Udp
            }
        }
        if (sips) transport = TransportType.Tls
        return "sip:$value;transport=${transport.name.lowercase()}"
    }

    fun pushGateway(): ProxyConfig? {
        return coreContext.core.getProxyConfigByIdkey(PUSH_GW_ID_KEY)
    }

    private fun removeAuthInfos(username: String) {
        val core = coreContext.core
        core.authInfoList.filter { it.username == username }.forEach { core.removeAuthInfo(it) }
    }

    fun disconnect() {
        val usernames = coreContext.core.accountList.mapNotNull { it.params.identityAddress?.username }
        coreContext.core.proxyConfigList.forEach {
            it.edit()
            it.expires = 0
            it.isPushNotificationAllowed = false
            it.done()
            coreContext.core.removeProxyConfig(it)
        }
        usernames.forEach { removeAuthInfos(it) }
    }

}
