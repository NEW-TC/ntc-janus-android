package org.linhome.synthetic.fragment_device_info.view

import android.view.View

val View.actions_list get() = findViewById<android.view.View>(org.linhome.R.id.actions_list)
val View.actions_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.actions_title)
val View.address get() = findViewById<android.widget.TextView>(org.linhome.R.id.address)
val View.call get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.call)
val View.device_image_card get() = findViewById<androidx.cardview.widget.CardView>(org.linhome.R.id.device_image_card)
val View.device_image_tablet get() = findViewById<org.linhome.ui.widgets.LDeviceImageView>(org.linhome.R.id.device_image_tablet)
val View.edit_device get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.edit_device)
val View.name get() = findViewById<android.widget.TextView>(org.linhome.R.id.name)
val View.top_separator get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.top_separator)
val View.type_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.type_icon)
val View.type_name get() = findViewById<android.widget.TextView>(org.linhome.R.id.type_name)
