package org.linhome.synthetic.widget_spinner

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.error get() = findViewById<android.widget.TextView>(org.linhome.R.id.error)
val Dialog.error get() = findViewById<android.widget.TextView>(org.linhome.R.id.error)
val Fragment.error get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.error)
val Activity.input get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.input)
val Dialog.input get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.input)
val Fragment.input get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.input)
val Activity.spinner get() = findViewById<android.widget.Spinner>(org.linhome.R.id.spinner)
val Dialog.spinner get() = findViewById<android.widget.Spinner>(org.linhome.R.id.spinner)
val Fragment.spinner get() = requireView().findViewById<android.widget.Spinner>(org.linhome.R.id.spinner)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
