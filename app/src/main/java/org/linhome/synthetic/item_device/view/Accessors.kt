package org.linhome.synthetic.item_device.view

import android.view.View

val View.address get() = findViewById<android.widget.TextView>(org.linhome.R.id.address)
val View.bottom_separator get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.bottom_separator)
val View.call get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.call)
val View.device_image get() = findViewById<org.linhome.ui.widgets.LDeviceImageView>(org.linhome.R.id.device_image)
val View.device_image_card get() = findViewById<androidx.cardview.widget.CardView>(org.linhome.R.id.device_image_card)
val View.name get() = findViewById<android.widget.TextView>(org.linhome.R.id.name)
val View.type_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.type_icon)
