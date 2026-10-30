package org.linhome.synthetic.fragment_devices.view

import android.view.View

val View.device_list get() = findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.device_list)
val View.deviceinfo get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.deviceinfo)
val View.devicelist get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.devicelist)
val View.new_device get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.new_device)
val View.new_device_none_configured get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.new_device_none_configured)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
