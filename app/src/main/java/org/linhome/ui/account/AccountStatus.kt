package org.linhome.ui.account

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import org.linhome.linphonecore.extensions.toHumanReadable
import org.linphone.core.RegistrationState

/** Отображение состояния SIP-регистрации: цветная точка и слово («Подключено», «Ошибка подключения»). */
object AccountStatus {
    const val DOT = "\u25CF"

    // зелёная - подключено, красная - ошибка, жёлтая - подключение, серая - нет соединения
    fun color(state: RegistrationState?): Int = when (state) {
        RegistrationState.Ok -> 0xFF2E9E4F.toInt()
        RegistrationState.Failed -> 0xFFD32F2F.toInt()
        RegistrationState.Progress, RegistrationState.Refreshing -> 0xFFF0A000.toInt()
        else -> 0xFF9E9E9E.toInt()
    }

    /** "● Подключено" с цветной точкой. */
    fun dotted(state: RegistrationState): SpannableString {
        val text = DOT + " " + state.toHumanReadable()
        val spannable = SpannableString(text)
        spannable.setSpan(ForegroundColorSpan(color(state)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(RelativeSizeSpan(1.4f), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannable
    }
}
