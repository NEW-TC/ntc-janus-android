package org.linhome.synthetic.fragment_history

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.loglist get() = findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.loglist)
val Dialog.loglist get() = findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.loglist)
val Fragment.loglist get() = requireView().findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.loglist)
val Activity.selectall get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.selectall)
val Dialog.selectall get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.selectall)
val Fragment.selectall get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.selectall)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
