package org.linhome.synthetic.fragment_assistant_remote_root.view

import android.view.View

val View.infobutton get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.infobutton)
val View.infotext get() = findViewById<android.widget.TextView>(org.linhome.R.id.infotext)
val View.qr get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.qr)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val View.url get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.url)
