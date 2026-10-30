package org.linhome.store

import org.linhome.LinhomeApplication
import org.linhome.customisation.ActionTypes
import org.linhome.customisation.DeviceTypes
import org.linhome.entities.Action
import org.linhome.entities.Device
import org.linphone.core.Config
import org.linphone.core.tools.Log

/**
 * Импорт устройств (домофонов), переданных в XML удалённой настройки секциями
 * ntc_device_0, ntc_device_1, ...:
 *   name, address, type (device_video_intercom ...), method_type (method_dtmf_sip_info ...),
 *   action_1_type (action_unlock ...), action_1_code (#), action_2_type, ...
 * Существующее устройство с тем же SIP-адресом обновляется, а не дублируется.
 * Секции после импорта удаляются из конфигурации ядра.
 */
object DeviceImporter {

    private const val SECTION_PREFIX = "ntc_device_"
    private const val MAX_ACTIONS = 8

    fun importFrom(config: Config): Int {
        var imported = 0
        config.sectionsNamesList.filter { it.startsWith(SECTION_PREFIX) }.forEach { section ->
            try {
                if (importSection(config, section)) imported++
            } catch (e: Exception) {
                Log.e("[Device Importer] Failed to import section $section: $e")
            }
            config.cleanSection(section)
        }
        return imported
    }

    private fun importSection(config: Config, section: String): Boolean {
        val name = config.getString(section, "name", null)?.trim()
        val rawAddress = config.getString(section, "address", null)?.trim()
        if (name.isNullOrEmpty() || rawAddress.isNullOrEmpty()) return false

        val address = LinhomeApplication.coreContext.core.createAddress(rawAddress)
            ?.asStringUriOnly() ?: return false

        val type = config.getString(section, "type", null)?.takeIf { DeviceTypes.isValidType(it) }
        val methodType = config.getString(section, "method_type", null)

        val actions = ArrayList<Action>()
        for (i in 1..MAX_ACTIONS) {
            val actionType = config.getString(section, "action_${i}_type", null) ?: continue
            val code = config.getString(section, "action_${i}_code", null) ?: continue
            if (ActionTypes.isValidType(actionType) && code.isNotEmpty())
                actions.add(Action(actionType, code))
        }

        val existing = DeviceStore.findDeviceByAddress(address)
        if (existing != null) {
            existing.name = name
            existing.type = type
            existing.actionsMethodType = methodType
            existing.actions = actions
            DeviceStore.sync()
        } else {
            DeviceStore.persistDevice(Device(type, name, address, methodType, actions))
        }
        return true
    }
}
