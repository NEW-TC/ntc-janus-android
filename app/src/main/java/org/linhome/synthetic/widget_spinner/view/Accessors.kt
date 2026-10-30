package org.linhome.synthetic.widget_spinner.view

import android.view.View

val View.error get() = findViewById<android.widget.TextView>(org.linhome.R.id.error)
val View.input get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.input)
val View.spinner get() = findViewById<android.widget.Spinner>(org.linhome.R.id.spinner)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
