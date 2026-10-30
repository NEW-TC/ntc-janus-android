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

package org.linhome.ui.assistant.loginsip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.linhome.synthetic.fragment_assistant_login_sip.view.*
import org.linhome.synthetic.widget_round_rect_button_with_icon.view.*
import org.linhome.R
import org.linhome.databinding.FragmentAssistantLoginSipBinding
import org.linhome.entities.Account
import org.linhome.ui.assistant.CreatorAssistantFragment
import org.linhome.ui.validators.ValidatorFactory
import org.linhome.utils.DialogUtil
import org.linphone.core.TransportType

class LoginSipAccountFragment : CreatorAssistantFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentAssistantLoginSipBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val model = ViewModelProvider(this).get(LoginSipAccountViewModel::class.java)
        binding.model = model
        binding.validators = ValidatorFactory.Companion

        binding.root.more.root.setOnClickListener {
            model.moreOptionsOpened.value = true
        }

        binding.root.loginsip.root.setOnClickListener {
            normalizeSipId(model)
            binding.executePendingBindings()
            binding.root.username.validate()
            binding.root.auth_id.validate()
            binding.root.password.validate()
            binding.root.domain.validate()
            binding.root.proxy.validate()
            binding.root.expiration.validate()
            updateField(model.setUsername(model.username), binding.root.username)
            updateField(model.setPassword(model.pass1), binding.root.password)
            updateField(model.setDomain(model.domain), binding.root.domain)
            model.setTransport(TransportType.values()[model.transport.value!!])
            if (model.valid()) {
                hideKeyboard()
                showProgress()
                Account.sipAccountLogin(
                    model.accountCreator,
                    model.proxy.first.value,
                    model.expiration.first.value!!,
                    model.authId.first.value!!.trim(),
                    model.pushReady
                )
            }
        }
        model.pushReady.observe(viewLifecycleOwner, Observer { pushready ->
            hideProgress()
            if (pushready) {
                DialogUtil.info("sip_account_created")
                mainactivity.navController.popBackStack(R.id.navigation_devices, false)
            } else
                DialogUtil.error("failed_creating_pushgateway")
        })

        return binding.root
    }

    /**
     * SIP ID можно вводить в любом виде: "user", "user@server" или "sip:user@server".
     * Префикс sip:/sips: отбрасывается, а часть после @ переносится в поле «Сервер», если оно пустое.
     */
    private fun normalizeSipId(model: LoginSipAccountViewModel) {
        var value = model.username.first.value?.trim() ?: return
        value = value.replace(Regex("^(?i)sips?:"), "")
        val at = value.indexOf('@')
        if (at >= 0) {
            val server = value.substring(at + 1).trim()
            value = value.substring(0, at)
            if (server.isNotEmpty() && model.domain.first.value.isNullOrBlank())
                model.domain.first.value = server
        }
        model.username.first.value = value
    }
}
