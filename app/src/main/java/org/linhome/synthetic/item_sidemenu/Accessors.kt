package org.linhome.synthetic.item_sidemenu

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.bottom_separator get() = findViewById<android.view.View>(org.linhome.R.id.bottom_separator)
val Dialog.bottom_separator get() = findViewById<android.view.View>(org.linhome.R.id.bottom_separator)
val Fragment.bottom_separator get() = requireView().findViewById<android.view.View>(org.linhome.R.id.bottom_separator)
val Activity.icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon)
val Dialog.icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon)
val Fragment.icon get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.icon)
val Activity.label get() = findViewById<android.widget.TextView>(org.linhome.R.id.label)
val Dialog.label get() = findViewById<android.widget.TextView>(org.linhome.R.id.label)
val Fragment.label get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.label)
val Activity.list_item get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.list_item)
val Dialog.list_item get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.list_item)
val Fragment.list_item get() = requireView().findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.list_item)
val Activity.top_separator get() = findViewById<android.view.View>(org.linhome.R.id.top_separator)
val Dialog.top_separator get() = findViewById<android.view.View>(org.linhome.R.id.top_separator)
val Fragment.top_separator get() = requireView().findViewById<android.view.View>(org.linhome.R.id.top_separator)
