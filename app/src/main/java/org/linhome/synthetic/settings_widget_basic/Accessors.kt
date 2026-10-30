package org.linhome.synthetic.settings_widget_basic

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.settings_subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Dialog.settings_subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Fragment.settings_subtitle get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Activity.settings_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
val Dialog.settings_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
val Fragment.settings_title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
