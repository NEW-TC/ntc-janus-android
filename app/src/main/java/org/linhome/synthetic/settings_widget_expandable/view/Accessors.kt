package org.linhome.synthetic.settings_widget_expandable.view

import android.view.View

val View.arrow get() = findViewById<android.widget.ImageView>(org.linhome.R.id.arrow)
val View.items get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.items)
val View.settings_subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_subtitle)
val View.settings_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.settings_title)
