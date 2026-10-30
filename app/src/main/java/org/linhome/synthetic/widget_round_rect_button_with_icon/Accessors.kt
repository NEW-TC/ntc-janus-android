package org.linhome.synthetic.widget_round_rect_button_with_icon

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon)
val Dialog.icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon)
val Fragment.icon get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.icon)
val Activity.root get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.root)
val Dialog.root get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.root)
val Fragment.root get() = requireView().findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.root)
val Activity.text get() = findViewById<android.widget.TextView>(org.linhome.R.id.text)
val Dialog.text get() = findViewById<android.widget.TextView>(org.linhome.R.id.text)
val Fragment.text get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.text)
