package org.linhome.push

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.linphone.mediastream.Log

/**
 * Обновление приложения и загрузка телефона: один раз перерегистрироваться без открытия приложения.
 * Службу на переднем плане не запускает (на Android 15 phoneCall из BOOT_COMPLETED запрещён), только задача WorkManager.
 */
class RegisterEventReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val reason = when (intent.action) {
            Intent.ACTION_MY_PACKAGE_REPLACED -> "package_replaced"
            Intent.ACTION_BOOT_COMPLETED -> "boot"
            else -> return
        }
        Log.i("[Register Receiver] событие: $reason")
        RegisterRefresh.scheduleOnce(context, reason)
    }
}
