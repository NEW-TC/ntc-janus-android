package org.linhome.synthetic.fragment_settings

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.debug_log_options get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.debug_log_options)
val Dialog.debug_log_options get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.debug_log_options)
val Fragment.debug_log_options get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.debug_log_options)
val Activity.send_logs get() = findViewById<android.view.View>(org.linhome.R.id.send_logs)
val Dialog.send_logs get() = findViewById<android.view.View>(org.linhome.R.id.send_logs)
val Fragment.send_logs get() = requireView().findViewById<android.view.View>(org.linhome.R.id.send_logs)
