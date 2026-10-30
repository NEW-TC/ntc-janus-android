package org.linhome.synthetic.widget_device_action_info_tablet_button

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.border get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.border)
val Dialog.border get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.border)
val Fragment.border get() = requireView().findViewById<android.widget.RelativeLayout>(org.linhome.R.id.border)
val Activity.button_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.button_icon)
val Dialog.button_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.button_icon)
val Fragment.button_icon get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.button_icon)
val Activity.button_text get() = findViewById<android.widget.TextView>(org.linhome.R.id.button_text)
val Dialog.button_text get() = findViewById<android.widget.TextView>(org.linhome.R.id.button_text)
val Fragment.button_text get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.button_text)
val Activity.textOffLabel get() = findViewById<android.widget.TextView>(org.linhome.R.id.textOffLabel)
val Dialog.textOffLabel get() = findViewById<android.widget.TextView>(org.linhome.R.id.textOffLabel)
val Fragment.textOffLabel get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.textOffLabel)
