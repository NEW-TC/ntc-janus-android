package org.linhome.synthetic.chunk_call_name_address.view

import android.view.View

val View.address get() = findViewById<android.widget.TextView>(org.linhome.R.id.address)
val View.name get() = findViewById<android.widget.TextView>(org.linhome.R.id.name)
