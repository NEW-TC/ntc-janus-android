package org.linhome.synthetic.fragment_history.view

import android.view.View

val View.loglist get() = findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.loglist)
val View.selectall get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.selectall)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
