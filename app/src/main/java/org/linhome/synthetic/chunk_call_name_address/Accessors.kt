package org.linhome.synthetic.chunk_call_name_address

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.address get() = findViewById<android.widget.TextView>(org.linhome.R.id.address)
val Dialog.address get() = findViewById<android.widget.TextView>(org.linhome.R.id.address)
val Fragment.address get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.address)
val Activity.name get() = findViewById<android.widget.TextView>(org.linhome.R.id.name)
val Dialog.name get() = findViewById<android.widget.TextView>(org.linhome.R.id.name)
val Fragment.name get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.name)
