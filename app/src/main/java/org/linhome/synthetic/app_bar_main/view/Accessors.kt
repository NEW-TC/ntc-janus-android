package org.linhome.synthetic.app_bar_main.view

import android.view.View

val View.progress get() = findViewById<androidx.core.widget.ContentLoadingProgressBar>(org.linhome.R.id.progress)
val View.toolbar get() = findViewById<androidx.appcompat.widget.Toolbar>(org.linhome.R.id.toolbar)
val View.toolbar_back_button get() = findViewById<android.widget.ImageButton>(org.linhome.R.id.toolbar_back_button)
val View.toolbar_burger_button get() = findViewById<android.widget.ImageButton>(org.linhome.R.id.toolbar_burger_button)
val View.toolbar_left_button get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.toolbar_left_button)
val View.toolbar_left_button_image get() = findViewById<android.widget.ImageView>(org.linhome.R.id.toolbar_left_button_image)
val View.toolbar_left_button_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.toolbar_left_button_title)
val View.toolbar_right_button get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.toolbar_right_button)
val View.toolbar_right_button_image get() = findViewById<android.widget.ImageView>(org.linhome.R.id.toolbar_right_button_image)
val View.toolbar_right_button_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.toolbar_right_button_title)
val View.toolbar_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.toolbar_title)
