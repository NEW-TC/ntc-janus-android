package org.linhome.push

import org.linhome.LinhomeApplication
import org.linphone.mediastream.Log
import ru.rustore.sdk.pushclient.messaging.model.RemoteMessage
import ru.rustore.sdk.pushclient.messaging.service.RuStoreMessagingService

/**
 * Приём push от RuStore. Процесс приложения уже запущен (ядро создаётся в Application.onCreate и регистрируется само).
 * Задача сервиса: убедиться, что ядро работает, и обновить регистрацию, чтобы Flexisip доставил вызов.
 */
class NtcPushService : RuStoreMessagingService() {

    override fun onNewToken(token: String) {
        LinhomeApplication.ensureCoreExists(applicationContext)
        NtcPush.onToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        val data = message.data
        Log.i("[RuStore Push] сообщение получено: type=${data["type"]}")
        LinhomeApplication.ensureCoreExists(applicationContext)
        val callId = data["call_id"]
        LinhomeApplication.coreContext.handler.post {
            val core = LinhomeApplication.coreContext.core
            if (!callId.isNullOrEmpty()) core.processPushNotification(callId)
            core.refreshRegisters()
        }
    }

    override fun onDeletedMessages() {
        Log.i("[RuStore Push] часть сообщений удалена (истёк срок хранения)")
    }

    override fun onError(errors: List<ru.rustore.sdk.pushclient.messaging.exception.RuStorePushClientException>) {
        Log.w("[RuStore Push] ошибка: $errors")
    }
}
