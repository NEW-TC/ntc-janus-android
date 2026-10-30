package org.linhome.synthetic.settings_widget_expandable

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.arrow get() = findViewById<android.widget.ImageView>(org.linhome.R.id.arrow)
val Dialog.arrow get() = findViewById<android.widget.ImageView>(org.linhome.R.id.arrow)
val Fragment.arrow get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.arrow)
val Activity.items get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.items)
val Dialog.items get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.items)
val Fragment.items get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.items)
val Activity.settings_subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Dialog.settings_subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Fragment.settings_subtitle get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val Activity.settings_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
val Dialog.settings_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
val Fragment.settings_title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
