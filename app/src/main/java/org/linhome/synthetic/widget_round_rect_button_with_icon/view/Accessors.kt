package org.linhome.synthetic.widget_round_rect_button_with_icon.view

import android.view.View

val View.icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon)
val View.root get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.root)
val View.text get() = findViewById<android.widget.TextView>(org.linhome.R.id.text)
