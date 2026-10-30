package org.linhome.synthetic.fragment_assistant_create_linhome

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.create get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.create)
val Dialog.create get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.create)
val Fragment.create get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.create)
val Activity.email get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.email)
val Dialog.email get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.email)
val Fragment.email get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.email)
val Activity.password get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Dialog.password get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Fragment.password get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Activity.password_confirmation get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password_confirmation)
val Dialog.password_confirmation get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password_confirmation)
val Fragment.password_confirmation get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password_confirmation)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Activity.username get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
val Dialog.username get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
val Fragment.username get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
