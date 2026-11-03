package org.linhome.push

import org.linhome.LinhomeApplication.Companion.coreContext
import org.linhome.LinhomeApplication.Companion.corePreferences
import org.linphone.core.Factory
import org.linphone.core.ProxyConfig
import org.linphone.mediastream.Log
import ru.rustore.sdk.core.feature.model.FeatureAvailabilityResult
import ru.rustore.sdk.pushclient.RuStorePushClient

/**
 * Push через RuStore: токен устройства передаётся в параметрах регистрации (Contact: pn-provider/pn-param/pn-prid),
 * чтобы прокси (Flexisip) мог разбудить приложение при входящем вызове.
 * Linphone SDK сам считает push-параметры только для Firebase, поэтому для RuStore они задаются вручную.
 */
object NtcPush {
    const val PROVIDER = "rustore"
    private const val PARAM = "ru.newtc.janus"   // pn-param: идентификатор приложения
    private const val CFG_SECTION = "ntc_push"
    private const val CFG_TOKEN = "rustore_token"

    /** Проверить доступность RuStore Push, получить токен и применить его к аккаунтам. */
    fun start() {
        RuStorePushClient.checkPushAvailability()
            .addOnSuccessListener { result ->
                when (result) {
                    FeatureAvailabilityResult.Available -> {
                        Log.i("[RuStore Push] доступен")
                        fetchToken()
                    }
                    is FeatureAvailabilityResult.Unavailable ->
                        Log.w("[RuStore Push] недоступен: ${result.cause}")
                }
            }
            .addOnFailureListener { Log.w("[RuStore Push] проверка доступности не удалась: $it") }
        applyStoredToken()   // токен мог быть получен раньше
    }

    private fun fetchToken() {
        RuStorePushClient.getToken()
            .addOnSuccessListener { token -> onToken(token) }
            .addOnFailureListener { Log.w("[RuStore Push] токен не получен: $it") }
    }

    /** Новый токен: запомнить и применить ко всем аккаунтам. */
    fun onToken(token: String) {
        Log.i("[RuStore Push] токен получен (...${token.takeLast(6)})")
        corePreferences.config.setString(CFG_SECTION, CFG_TOKEN, token)
        applyStoredToken()
    }

    /** Адреса прокси, через которые регистрируются push-аккаунты (наш Flexisip). На остальных (SBC) push-параметры не нужны и ломают регистрацию. */
    private val PUSH_PROXY_HOSTS = setOf("push.new-tc.ru")

    private fun usesPushProxy(proxyConfig: ProxyConfig): Boolean {
        val host = proxyConfig.serverAddr?.let { Factory.instance().createAddress(it)?.domain } ?: return false
        return host.lowercase() in PUSH_PROXY_HOSTS
    }

    /**
     * Применить сохранённый токен к аккаунтам с push-прокси; у остальных убрать push-параметры
     * (длинный Contact отвергается SBC: 400 "Contact/received too long").
     */
    fun applyStoredToken() {
        val token = corePreferences.config.getString(CFG_SECTION, CFG_TOKEN, null)
        coreContext.handler.post {
            val core = coreContext.core
            var changed = false
            core.proxyConfigList.forEach { proxyConfig ->
                val current = proxyConfig.pushNotificationConfig
                if (usesPushProxy(proxyConfig)) {
                    if (token == null) return@forEach
                    if (current.provider == PROVIDER && current.prid == token && proxyConfig.isPushNotificationAllowed) return@forEach
                    val config = current.clone()
                    config.provider = PROVIDER
                    config.param = PARAM
                    config.prid = token
                    proxyConfig.edit()
                    proxyConfig.pushNotificationConfig = config
                    proxyConfig.isPushNotificationAllowed = true
                    proxyConfig.done()
                    changed = true
                } else if (current.provider == PROVIDER) {
                    val config = current.clone()
                    config.provider = ""
                    config.param = ""
                    config.prid = ""
                    proxyConfig.edit()
                    proxyConfig.pushNotificationConfig = config
                    proxyConfig.isPushNotificationAllowed = false
                    proxyConfig.done()
                    changed = true
                }
            }
            if (changed) {
                Log.i("[RuStore Push] параметры push обновлены, обновляю регистрацию")
                core.refreshRegisters()
            }
        }
    }
}
