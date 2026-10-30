package org.linhome.synthetic.fragment_sidemenu

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.disconnect get() = findViewById<android.view.View>(org.linhome.R.id.disconnect)
val Dialog.disconnect get() = findViewById<android.view.View>(org.linhome.R.id.disconnect)
val Fragment.disconnect get() = requireView().findViewById<android.view.View>(org.linhome.R.id.disconnect)
val Activity.list get() = findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.list)
val Dialog.list get() = findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.list)
val Fragment.list get() = requireView().findViewById<androidx.recyclerview.widget.RecyclerView>(org.linhome.R.id.list)
