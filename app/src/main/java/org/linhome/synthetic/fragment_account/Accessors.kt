package org.linhome.synthetic.fragment_account

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.account get() = findViewById<android.widget.TextView>(org.linhome.R.id.account)
val Dialog.account get() = findViewById<android.widget.TextView>(org.linhome.R.id.account)
val Fragment.account get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.account)
val Activity.disconnect get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.disconnect)
val Dialog.disconnect get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.disconnect)
val Fragment.disconnect get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.disconnect)
val Activity.pushaccount get() = findViewById<android.widget.TextView>(org.linhome.R.id.pushaccount)
val Dialog.pushaccount get() = findViewById<android.widget.TextView>(org.linhome.R.id.pushaccount)
val Fragment.pushaccount get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.pushaccount)
val Activity.refresh_registers get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.refresh_registers)
val Dialog.refresh_registers get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.refresh_registers)
val Fragment.refresh_registers get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.refresh_registers)
