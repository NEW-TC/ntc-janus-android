package org.linhome.synthetic.fragment_devices

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.device_list get() = findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.device_list)
val Dialog.device_list get() = findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.device_list)
val Fragment.device_list get() = requireView().findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.device_list)
val Activity.deviceinfo get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.deviceinfo)
val Dialog.deviceinfo get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.deviceinfo)
val Fragment.deviceinfo get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.deviceinfo)
val Activity.devicelist get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.devicelist)
val Dialog.devicelist get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.devicelist)
val Fragment.devicelist get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.devicelist)
val Activity.new_device get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.new_device)
val Dialog.new_device get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.new_device)
val Fragment.new_device get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.new_device)
val Activity.new_device_none_configured get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.new_device_none_configured)
val Dialog.new_device_none_configured get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.new_device_none_configured)
val Fragment.new_device_none_configured get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.new_device_none_configured)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
