package org.linhome.synthetic.settings_widget_spinner

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.arrow get() = findViewById<android.widget.ImageView>(org.linhome.R.id.arrow)
val Dialog.arrow get() = findViewById<android.widget.ImageView>(org.linhome.R.id.arrow)
val Fragment.arrow get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.arrow)
val Activity.settings_spinner get() = findViewById<android.widget.Spinner>(org.linhome.R.id.settings_spinner)
val Dialog.settings_spinner get() = findViewById<android.widget.Spinner>(org.linhome.R.id.settings_spinner)
val Fragment.settings_spinner get() = requireView().findViewById<android.widget.Spinner>(org.linhome.R.id.settings_spinner)
val Activity.settings_subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Dialog.settings_subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Fragment.settings_subtitle get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Activity.settings_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
val Dialog.settings_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
val Fragment.settings_title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
