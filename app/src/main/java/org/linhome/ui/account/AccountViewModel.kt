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

package org.linhome.ui.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.linhome.LinhomeApplication
import org.linhome.customisation.Texts
import org.linhome.entities.Account
import org.linhome.linphonecore.extensions.toHumanReadable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import org.linphone.core.*

class AccountViewModel : ViewModel() {
    val account = Account.get()
    val pushGw = Account.pushGateway()
    val accountDesc = MutableLiveData<CharSequence?>(getDescription("account_info",account))
    val pushGWDesc = MutableLiveData<CharSequence?>(getDescription("push_account_info",pushGw))

    private val coreListener = object : CoreListenerStub() {
        override fun onRegistrationStateChanged(
            lc: Core,
            cfg: ProxyConfig,
            cstate: RegistrationState?,
            message: String
        ) {
            if (cfg != null) {
                if (cfg == account)
                    accountDesc.value = getDescription("account_info",account)
                if (cfg == pushGw)
                    pushGWDesc.value = getDescription("push_account_info",pushGw)
            }
        }
    }

    init {
        LinhomeApplication.coreContext.core.addListener(coreListener)
    }

    override fun onCleared() {
        LinhomeApplication.coreContext.core.removeListener(coreListener)
        super.onCleared()
    }

    fun refreshRegisters() {
        account?.refreshRegister()
        pushGw?.refreshRegister()
    }


    // Цветная точка перед статусом: зелёная - подключено, красная - ошибка, жёлтая - подключение.
    private fun statusColor(state: RegistrationState?): Int = when (state) {
        RegistrationState.Ok -> 0xFF2E9E4F.toInt()
        RegistrationState.Failed -> 0xFFD32F2F.toInt()
        RegistrationState.Progress, RegistrationState.Refreshing -> 0xFFF0A000.toInt()
        else -> 0xFF9E9E9E.toInt()
    }

    fun getDescription(key:String, proxyConfig: ProxyConfig?): CharSequence? {
        val state = proxyConfig?.state
        val identity = proxyConfig?.identityAddress?.asStringUriOnly()
        if (state == null || identity == null)
            return Texts.get("no_account_configured")
        val dot = "●"
        val text = Texts.get(key, identity, "$dot ${state.toHumanReadable()}")
        val spannable = SpannableString(text)
        val index = text.lastIndexOf(dot)
        if (index >= 0) {
            spannable.setSpan(ForegroundColorSpan(statusColor(state)), index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            spannable.setSpan(RelativeSizeSpan(1.4f), index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return spannable
    }


}
