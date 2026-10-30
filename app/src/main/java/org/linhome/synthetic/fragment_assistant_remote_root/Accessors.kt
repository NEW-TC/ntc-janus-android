package org.linhome.synthetic.fragment_assistant_remote_root

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.infobutton get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.infobutton)
val Dialog.infobutton get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.infobutton)
val Fragment.infobutton get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.infobutton)
val Activity.infotext get() = findViewById<android.widget.TextView>(org.linhome.R.id.infotext)
val Dialog.infotext get() = findViewById<android.widget.TextView>(org.linhome.R.id.infotext)
val Fragment.infotext get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.infotext)
val Activity.qr get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.qr)
val Dialog.qr get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.qr)
val Fragment.qr get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.qr)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Activity.url get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.url)
val Dialog.url get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.url)
val Fragment.url get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.url)
