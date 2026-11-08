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
        val proxyConfig: ProxyConfig? = accountCreator.createProxyConfig()
        // AccountCreator формирует identity вида sip:user:user@domain; задаём явно sip:user@domain.
        val cleanIdentity = coreContext.core.createAddress("sip:${accountCreator.username}@${accountCreator.domain}")
        if (proxyConfig != null && cleanIdentity != null) {
            proxyConfig.edit()
            proxyConfig.identityAddress = cleanIdentity
            proxyConfig.done()
        }
        // Auth ID (userid) отличается от SIP ID (username) на нашей ВАТС.
        proxyConfig?.findAuthInfo()?.also {
            it.userid = authId
            coreContext.core.addAuthInfo(it)
        }
        proxyConfig?.expires = expiration.toInt()
        if (!TextUtils.isEmpty(proxy)) {
            // Исходящий прокси: пакеты идут на него, а адрес регистратора (домен аккаунта) не меняется
            proxyConfig?.setRoutes(arrayOf(normalizeProxy(proxy!!, accountCreator.transport)))
        }
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

    fun disconnect() {
        coreContext.core.proxyConfigList.forEach {
            it.edit()
            it.expires = 0
            it.isPushNotificationAllowed = false
            it.done()
            coreContext.core.removeProxyConfig(it)
        }
    }

}
