package org.linhome.synthetic.item_device

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.address get() = findViewById<android.widget.TextView>(org.linhome.R.id.address)
val Dialog.address get() = findViewById<android.widget.TextView>(org.linhome.R.id.address)
val Fragment.address get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.address)
val Activity.bottom_separator get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.bottom_separator)
val Dialog.bottom_separator get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.bottom_separator)
val Fragment.bottom_separator get() = requireView().findViewById<android.widget.RelativeLayout>(org.linhome.R.id.bottom_separator)
val Activity.call get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.call)
val Dialog.call get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.call)
val Fragment.call get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.call)
val Activity.device_image get() = findViewById<org.linhome.ui.widgets.LDeviceImageView>(org.linhome.R.id.device_image)
val Dialog.device_image get() = findViewById<org.linhome.ui.widgets.LDeviceImageView>(org.linhome.R.id.device_image)
val Fragment.device_image get() = requireView().findViewById<org.linhome.ui.widgets.LDeviceImageView>(org.linhome.R.id.device_image)
val Activity.device_image_card get() = findViewById<androidx.cardview.widget.CardView>(org.linhome.R.id.device_image_card)
val Dialog.device_image_card get() = findViewById<androidx.cardview.widget.CardView>(org.linhome.R.id.device_image_card)
val Fragment.device_image_card get() = requireView().findViewById<androidx.cardview.widget.CardView>(org.linhome.R.id.device_image_card)
val Activity.name get() = findViewById<android.widget.TextView>(org.linhome.R.id.name)
val Dialog.name get() = findViewById<android.widget.TextView>(org.linhome.R.id.name)
val Fragment.name get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.name)
val Activity.type_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.type_icon)
val Dialog.type_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.type_icon)
val Fragment.type_icon get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.type_icon)
