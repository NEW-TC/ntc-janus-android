package org.linhome.synthetic.fragment_about

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.appversion get() = findViewById<android.widget.TextView>(org.linhome.R.id.appversion)
val Dialog.appversion get() = findViewById<android.widget.TextView>(org.linhome.R.id.appversion)
val Fragment.appversion get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.appversion)
val Activity.copyright get() = findViewById<android.widget.TextView>(org.linhome.R.id.copyright)
val Dialog.copyright get() = findViewById<android.widget.TextView>(org.linhome.R.id.copyright)
val Fragment.copyright get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.copyright)
val Activity.licence get() = findViewById<android.widget.TextView>(org.linhome.R.id.licence)
val Dialog.licence get() = findViewById<android.widget.TextView>(org.linhome.R.id.licence)
val Fragment.licence get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.licence)
val Activity.linhome_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_icon)
val Dialog.linhome_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_icon)
val Fragment.linhome_icon get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_icon)
val Activity.linhome_link get() = findViewById<android.widget.TextView>(org.linhome.R.id.linhome_link)
val Dialog.linhome_link get() = findViewById<android.widget.TextView>(org.linhome.R.id.linhome_link)
val Fragment.linhome_link get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.linhome_link)
val Activity.linhome_text get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_text)
val Dialog.linhome_text get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_text)
val Fragment.linhome_text get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_text)
val Activity.linhome_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.linhome_title)
val Dialog.linhome_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.linhome_title)
val Fragment.linhome_title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.linhome_title)
val Activity.screen get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.screen)
val Dialog.screen get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.screen)
val Fragment.screen get() = requireView().findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.screen)
val Activity.sdkversion get() = findViewById<android.widget.TextView>(org.linhome.R.id.sdkversion)
val Dialog.sdkversion get() = findViewById<android.widget.TextView>(org.linhome.R.id.sdkversion)
val Fragment.sdkversion get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.sdkversion)
val Activity.texts get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.texts)
val Dialog.texts get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.texts)
val Fragment.texts get() = requireView().findViewById<android.widget.RelativeLayout>(org.linhome.R.id.texts)
