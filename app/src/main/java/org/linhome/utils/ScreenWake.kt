package org.linhome.utils

import android.content.Context
import android.os.PowerManager
import org.linphone.mediastream.Log

/**
 * Включить экран при входящем звонке. Флага окна FLAG_TURN_SCREEN_ON достаточно на Samsung, но на MIUI экран не
 * загорается, поэтому дополнительно берём короткую блокировку с пробуждением.
 */
object ScreenWake {
    @Suppress("DEPRECATION")
    fun wake(context: Context, millis: Long = 10_000) {
        try {
            val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            if (pm.isInteractive) return
            val lock = pm.newWakeLock(
                PowerManager.SCREEN_BRIGHT_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP or PowerManager.ON_AFTER_RELEASE,
                "ntc:incoming_call"
            )
            lock.acquire(millis)
            Log.i("[Screen Wake] экран включён блокировкой на ${millis} мс")
        } catch (e: Exception) {
            Log.w("[Screen Wake] не удалось включить экран: $e")
        }
    }
}
