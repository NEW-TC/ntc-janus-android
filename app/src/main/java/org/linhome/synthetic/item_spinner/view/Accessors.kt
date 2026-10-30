package org.linhome.synthetic.item_spinner.view

import android.view.View

val View.arrow get() = findViewById<android.widget.ImageView>(org.linhome.R.id.arrow)
val View.bottom_separator get() = findViewById<android.view.View>(org.linhome.R.id.bottom_separator)
val View.icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon)
val View.label get() = findViewById<android.widget.TextView>(org.linhome.R.id.label)
val View.list_item get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.list_item)
val View.top_separator get() = findViewById<android.view.View>(org.linhome.R.id.top_separator)
