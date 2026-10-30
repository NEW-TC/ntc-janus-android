package org.linhome.synthetic.content_main

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.host_fragment_sidemenu get() = findViewById<android.view.View>(org.linhome.R.id.host_fragment_sidemenu)
val Dialog.host_fragment_sidemenu get() = findViewById<android.view.View>(org.linhome.R.id.host_fragment_sidemenu)
val Fragment.host_fragment_sidemenu get() = requireView().findViewById<android.view.View>(org.linhome.R.id.host_fragment_sidemenu)
val Activity.icon_devices get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon_devices)
val Dialog.icon_devices get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon_devices)
val Fragment.icon_devices get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.icon_devices)
val Activity.icon_history get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon_history)
val Dialog.icon_history get() = findViewById<android.widget.ImageView>(org.linhome.R.id.icon_history)
val Fragment.icon_history get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.icon_history)
val Activity.navigation_host_fragment get() = findViewById<android.view.View>(org.linhome.R.id.navigation_host_fragment)
val Dialog.navigation_host_fragment get() = findViewById<android.view.View>(org.linhome.R.id.navigation_host_fragment)
val Fragment.navigation_host_fragment get() = requireView().findViewById<android.view.View>(org.linhome.R.id.navigation_host_fragment)
val Activity.tabbar get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar)
val Dialog.tabbar get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar)
val Fragment.tabbar get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar)
val Activity.tabbar_devices get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar_devices)
val Dialog.tabbar_devices get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar_devices)
val Fragment.tabbar_devices get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar_devices)
val Activity.tabbar_history get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar_history)
val Dialog.tabbar_history get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar_history)
val Fragment.tabbar_history get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.tabbar_history)
val Activity.text_devices get() = findViewById<android.widget.TextView>(org.linhome.R.id.text_devices)
val Dialog.text_devices get() = findViewById<android.widget.TextView>(org.linhome.R.id.text_devices)
val Fragment.text_devices get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.text_devices)
val Activity.text_history get() = findViewById<android.widget.TextView>(org.linhome.R.id.text_history)
val Dialog.text_history get() = findViewById<android.widget.TextView>(org.linhome.R.id.text_history)
val Fragment.text_history get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.text_history)
val Activity.unread_count get() = findViewById<android.widget.TextView>(org.linhome.R.id.unread_count)
val Dialog.unread_count get() = findViewById<android.widget.TextView>(org.linhome.R.id.unread_count)
val Fragment.unread_count get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.unread_count)
