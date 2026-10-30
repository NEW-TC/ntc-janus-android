package org.linhome.synthetic.fragment_assistant_root

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.remote get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.remote)
val Dialog.remote get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.remote)
val Fragment.remote get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.remote)
val Activity.sip get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.sip)
val Dialog.sip get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.sip)
val Fragment.sip get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.sip)
val Activity.subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.subtitle)
val Dialog.subtitle get() = findViewById<android.widget.TextView>(org.linhome.R.id.subtitle)
val Fragment.subtitle get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.subtitle)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
