package org.linhome.synthetic.widget_segmented_control.view

import android.view.View

val View.buttons get() = findViewById<com.google.android.material.button.MaterialButtonToggleGroup>(org.linhome.R.id.buttons)
val View.error get() = findViewById<android.widget.TextView>(org.linhome.R.id.error)
val View.option1 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option1)
val View.option2 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option2)
val View.option3 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option3)
val View.root get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.root)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
