package org.linhome.synthetic.fragment_assistant_remote_qr

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.header_opaque get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.header_opaque)
val Dialog.header_opaque get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.header_opaque)
val Fragment.header_opaque get() = requireView().findViewById<android.widget.RelativeLayout>(org.linhome.R.id.header_opaque)
val Activity.infobutton get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.infobutton)
val Dialog.infobutton get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.infobutton)
val Fragment.infobutton get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.infobutton)
val Activity.infotext get() = findViewById<android.widget.TextView>(org.linhome.R.id.infotext)
val Dialog.infotext get() = findViewById<android.widget.TextView>(org.linhome.R.id.infotext)
val Fragment.infotext get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.infotext)
val Activity.mask get() = findViewById<android.widget.ImageView>(org.linhome.R.id.mask)
val Dialog.mask get() = findViewById<android.widget.ImageView>(org.linhome.R.id.mask)
val Fragment.mask get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.mask)
val Activity.mask_container get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.mask_container)
val Dialog.mask_container get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.mask_container)
val Fragment.mask_container get() = requireView().findViewById<android.widget.RelativeLayout>(org.linhome.R.id.mask_container)
val Activity.qrcode get() = findViewById<android.view.TextureView>(org.linhome.R.id.qrcode)
val Dialog.qrcode get() = findViewById<android.view.TextureView>(org.linhome.R.id.qrcode)
val Fragment.qrcode get() = requireView().findViewById<android.view.TextureView>(org.linhome.R.id.qrcode)
val Activity.subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.subtitle)
val Dialog.subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.subtitle)
val Fragment.subtitle get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.subtitle)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
