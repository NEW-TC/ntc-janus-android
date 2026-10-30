package org.linhome.synthetic.fragment_assistant_remote_qr.view

import android.view.View

val View.header_opaque get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.header_opaque)
val View.infobutton get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.infobutton)
val View.infotext get() = findViewById<android.widget.TextView>(org.linhome.R.id.infotext)
val View.mask get() = findViewById<android.widget.ImageView>(org.linhome.R.id.mask)
val View.mask_container get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.mask_container)
val View.qrcode get() = findViewById<android.view.TextureView>(org.linhome.R.id.qrcode)
val View.subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.subtitle)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
