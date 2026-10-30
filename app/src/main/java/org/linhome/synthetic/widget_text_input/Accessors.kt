package org.linhome.synthetic.widget_text_input

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
val Activity.text get() = findViewById<org.linhome.ui.widgets.LEditText>(org.linhome.R.id.text)
val Dialog.text get() = findViewById<org.linhome.ui.widgets.LEditText>(org.linhome.R.id.text)
val Fragment.text get() = requireView().findViewById<org.linhome.ui.widgets.LEditText>(org.linhome.R.id.text)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
