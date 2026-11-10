package org.linhome.push

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Process
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.withTimeoutOrNull
import org.linhome.LinhomeApplication
import org.linhome.LinhomeApplication.Companion.coreContext
import org.linphone.core.Account
import org.linphone.core.Core
import org.linphone.core.CoreListenerStub
import org.linphone.core.RegistrationState
import org.linphone.mediastream.Log
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Фоновая перерегистрация push-аккаунта на Flexisip: служебный push register_wakeup, периодическая задача,
 * обновление приложения и загрузка телефона. Без уведомлений и экранов.
 */
object RegisterRefresh {

    private const val PERIODIC_WORK = "ntc_register_periodic"
    private const val ONESHOT_WORK = "ntc_register_once"
    private const val RETRY_WORK = "ntc_register_retry"
    private const val TIMEOUT_MS = 15_000L
    private val running = AtomicBoolean(false)

    /** Обновить регистрацию и дождаться результата (до 15 с). Параллельные вызовы объединяются. */
    suspend fun run(reason: String, timeoutMs: Long = TIMEOUT_MS): Boolean {
        if (!running.compareAndSet(false, true)) {
            Log.i("[Register Refresh] уже выполняется, пропускаю ($reason)")
            return true
        }
        val started = System.currentTimeMillis()
        try {
            LinhomeApplication.ensureCoreExists(LinhomeApplication.instance.applicationContext)
            val handler = coreContext.handler
            val done = CompletableDeferred<Boolean>()
            var hasPush = false
            val listener = object : CoreListenerStub() {
                override fun onAccountRegistrationStateChanged(core: Core, account: Account, state: RegistrationState, message: String) {
                    when (state) {
                        RegistrationState.Ok -> done.complete(true)
                        RegistrationState.Failed -> done.complete(false)
                        else -> {}
                    }
                }
            }
            handler.post {
                val core = coreContext.core
                hasPush = NtcPush.hasPushAccount()
                if (!hasPush) {
                    done.complete(true)
                } else {
                    core.addListener(listener)
                    core.refreshRegisters()
                }
            }
            val ok = withTimeoutOrNull(timeoutMs) { done.await() } ?: false
            handler.post { coreContext.core.removeListener(listener) }
            Log.i("[Register Refresh] причина=$reason, push-аккаунт=${hasPush}, результат=${if (ok) "OK" else "нет"}, ${System.currentTimeMillis() - started} мс")
            if (!ok && hasPush) {
                // Например, нет сети в Doze: повторим, когда Android даст сеть (WorkManager с условием «есть сеть»)
                Log.i("[Register Refresh] планирую повтор при появлении сети")
                scheduleRetry(LinhomeApplication.instance.applicationContext)
            }
            return ok
        } finally {
            running.set(false)
        }
    }

    /** Периодическая перерегистрация раз в 8 часов при наличии сети. */
    fun schedulePeriodic(context: Context) {
        val request = PeriodicWorkRequestBuilder<RegisterWorker>(8, TimeUnit.HOURS)
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .setInputData(workDataOf("reason" to "periodic"))
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(PERIODIC_WORK, ExistingPeriodicWorkPolicy.KEEP, request)
    }

    /** Повтор после неудачной перерегистрации: запускается, как только есть сеть, с нарастающей паузой. */
    fun scheduleRetry(context: Context) {
        val request = OneTimeWorkRequestBuilder<RegisterWorker>()
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .setBackoffCriteria(androidx.work.BackoffPolicy.EXPONENTIAL, 1, TimeUnit.MINUTES)
            .setInputData(workDataOf("reason" to "retry"))
            .build()
        WorkManager.getInstance(context).enqueueUniqueWork(RETRY_WORK, ExistingWorkPolicy.KEEP, request)
    }

    /** Разовая перерегистрация (после обновления приложения или загрузки телефона). */
    fun scheduleOnce(context: Context, reason: String) {
        val request = OneTimeWorkRequestBuilder<RegisterWorker>()
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .setInputData(workDataOf("reason" to reason))
            .build()
        WorkManager.getInstance(context).enqueueUniqueWork(ONESHOT_WORK, ExistingWorkPolicy.REPLACE, request)
    }

    /**
     * Процесс, поднятый из BOOT_COMPLETED, на Android 15 потом не может запустить службу phoneCall (звонок по push падал).
     * После перерегистрации по загрузке завершаем процесс, если интерфейс не открыт и нет вызовов: следующий push
     * поднимет приложение заново с обычной причиной запуска.
     */
    fun exitIfIdle() {
        Handler(Looper.getMainLooper()).postDelayed({
            val core = coreContext.core
            val uiVisible = ProcessLifecycleOwner.get().lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)
            if (!uiVisible && core.callsNb == 0) {
                Log.i("[Register Refresh] завершаю фоновый процесс после загрузки")
                Process.killProcess(Process.myPid())
            }
        }, 3_000)
    }
}

class RegisterWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val reason = inputData.getString("reason") ?: "periodic"
        val ok = RegisterRefresh.run(reason)
        if (reason == "boot") RegisterRefresh.exitIfIdle()
        // Повторная задача: пока не получилось, WorkManager повторяет с нарастающей паузой (до 5 попыток)
        return if (!ok && reason == "retry" && runAttemptCount < 5) Result.retry() else Result.success()
    }
}
