package org.linhome.ui.devices

import android.text.SpannableStringBuilder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.linhome.LinhomeApplication.Companion.coreContext
import org.linhome.customisation.Texts
import org.linhome.entities.Account
import org.linhome.entities.Device
import org.linhome.store.DeviceStore
import org.linhome.ui.account.AccountStatus
import org.linphone.core.Core
import org.linphone.core.CoreListenerStub
import org.linphone.core.ProxyConfig
import org.linphone.core.RegistrationState

class DevicesViewModel : ViewModel() {
    val devices = MutableLiveData<ArrayList<Device>>().apply {
        value = DeviceStore.devices
    }
    var selectedDevice = MutableLiveData<Device?>()

    // Состояние SIP-регистрации над списком устройств: «SIP-соединение: ● Подключено» или «Аккаунт не настроен»
    val accountStatus = MutableLiveData<CharSequence?>(describeStatus())

    private val coreListener = object : CoreListenerStub() {
        override fun onRegistrationStateChanged(
            core: Core,
            proxyConfig: ProxyConfig,
            state: RegistrationState?,
            message: String
        ) {
            accountStatus.postValue(describeStatus())
        }

        // Аккаунт добавлен/удалён/сменён: обновляем статус сразу, а не только при смене регистрации
        override fun onAccountAdded(core: Core, account: org.linphone.core.Account) {
            accountStatus.postValue(describeStatus())
        }

        override fun onAccountRemoved(core: Core, account: org.linphone.core.Account) {
            accountStatus.postValue(describeStatus())
        }

        override fun onDefaultAccountChanged(core: Core, account: org.linphone.core.Account?) {
            accountStatus.postValue(describeStatus())
        }
    }

    init {
        coreContext.core.addListener(coreListener)
    }

    override fun onCleared() {
        coreContext.core.removeListener(coreListener)
        super.onCleared()
    }

    private fun describeStatus(): CharSequence {
        val state = Account.get()?.state ?: return Texts.get("devices_no_account")
        return SpannableStringBuilder()
            .append(Texts.get("devices_sip_status_label"))
            .append(" ")
            .append(AccountStatus.dotted(state))
    }
}
