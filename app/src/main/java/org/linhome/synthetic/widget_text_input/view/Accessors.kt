package org.linhome.synthetic.widget_text_input.view

import android.view.View

val View.error get() = findViewById<android.widget.TextView>(org.linhome.R.id.error)
val View.input get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.input)
val View.text get() = findViewById<org.linhome.ui.widgets.LEditText>(org.linhome.R.id.text)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
