package org.linhome.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import org.linphone.mediastream.Log

/**
 * Помощник «Работа в фоне»: на прошивках с агрессивной экономией (Xiaomi/MIUI, Huawei/Honor, OPPO/Realme, Vivo и др.)
 * без автозапуска и разрешений «в фоне» push не будит приложение и звонок не показывается.
 * Диалог ведёт пользователя на нужные экраны настроек. Показывается один раз после настройки аккаунта и по кнопке
 * «Работа в фоне» на экране «Мой аккаунт».
 */
object BackgroundSettings {

    private const val PREFS = "ntc_background"
    private const val KEY_SHOWN = "dialog_shown"

    private val manufacturer = Build.MANUFACTURER.lowercase()

    private val oemWithAutostart = listOf("xiaomi", "redmi", "poco", "huawei", "honor", "oppo", "realme", "vivo", "iqoo", "meizu", "asus", "letv", "oneplus")

    /** Нужен ли такой телефону автоматический показ диалога. */
    fun isRestrictiveOem(): Boolean = oemWithAutostart.any { manufacturer.contains(it) }

    /** Показать диалог один раз (для «агрессивных» прошивок). */
    fun promptOnce(activity: Activity) {
        if (!isRestrictiveOem()) return
        val prefs = activity.getSharedPreferences(PREFS, 0)
        if (prefs.getBoolean(KEY_SHOWN, false)) return
        prefs.edit().putBoolean(KEY_SHOWN, true).apply()
        showDialog(activity)
    }

    fun showDialog(activity: Activity) {
        val items = ArrayList<Pair<String, () -> Unit>>()
        if (autostartIntents().isNotEmpty())
            items.add("Автозапуск приложения" to { openFirst(activity, autostartIntents()) })
        if (manufacturer.contains("xiaomi") || manufacturer.contains("redmi") || manufacturer.contains("poco"))
            items.add("Права: всплывающие окна и экран блокировки" to { openFirst(activity, listOf(miuiPermissionEditor(activity))) })
        items.add("Экономия батареи: выберите «Не ограничивать»" to { openFirst(activity, listOf(Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS))) })
        items.add("Настройки приложения" to { openFirst(activity, listOf(appDetails(activity))) })

        // Список (setItems) не показывается, если задан setMessage: объяснение выводим в собственном заголовке
        val density = activity.resources.displayMetrics.density
        val pad = (20 * density).toInt()
        val header = android.widget.LinearLayout(activity).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            setPadding(pad, pad, pad, (8 * density).toInt())
            addView(android.widget.TextView(activity).apply {
                text = "Работа в фоне"
                textSize = 20f
                setTypeface(typeface, android.graphics.Typeface.BOLD)
            })
            addView(android.widget.TextView(activity).apply {
                text = "Чтобы звонки с вызывной панели приходили, когда приложение закрыто, на этом телефоне нужно разрешить автозапуск и работу в фоне. Выберите настройку:"
                textSize = 15f
                setPadding(0, (10 * density).toInt(), 0, 0)
            })
        }
        AlertDialog.Builder(activity)
            .setCustomTitle(header)
            .setItems(items.map { it.first }.toTypedArray()) { _, which -> items[which].second() }
            .setNegativeButton("Закрыть", null)
            .show()
    }

    private fun autostartIntents(): List<Intent> = when {
        manufacturer.contains("xiaomi") || manufacturer.contains("redmi") || manufacturer.contains("poco") -> listOf(
            component("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")
        )
        manufacturer.contains("huawei") || manufacturer.contains("honor") -> listOf(
            component("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"),
            component("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")
        )
        manufacturer.contains("oppo") || manufacturer.contains("realme") || manufacturer.contains("oneplus") -> listOf(
            component("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"),
            component("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")
        )
        manufacturer.contains("vivo") || manufacturer.contains("iqoo") -> listOf(
            component("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")
        )
        else -> emptyList()
    }

    private fun component(pkg: String, cls: String) = Intent().setComponent(ComponentName(pkg, cls))

    private fun miuiPermissionEditor(activity: Activity) =
        Intent("miui.intent.action.APP_PERM_EDITOR").putExtra("extra_pkgname", activity.packageName)

    private fun appDetails(activity: Activity) =
        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${activity.packageName}"))

    /** Открыть первый доступный экран из списка; если ни один не открылся, показать сведения о приложении. */
    private fun openFirst(activity: Activity, intents: List<Intent>) {
        for (intent in intents) {
            try {
                activity.startActivity(intent)
                return
            } catch (e: Exception) {
                Log.w("[Background Settings] не удалось открыть $intent: $e")
            }
        }
        try {
            activity.startActivity(appDetails(activity))
        } catch (e: Exception) {
            Log.e("[Background Settings] нет доступных экранов настроек: $e")
        }
    }
}
