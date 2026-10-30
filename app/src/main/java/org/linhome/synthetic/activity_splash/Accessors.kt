package org.linhome.synthetic.activity_splash

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.linhome_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_icon)
val Dialog.linhome_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_icon)
val Fragment.linhome_icon get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_icon)
val Activity.linhome_text get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_text)
val Dialog.linhome_text get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_text)
val Fragment.linhome_text get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_text)
val Activity.linhome_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.linhome_title)
val Dialog.linhome_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.linhome_title)
val Fragment.linhome_title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.linhome_title)
val Activity.screen get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.screen)
val Dialog.screen get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.screen)
val Fragment.screen get() = requireView().findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.screen)
