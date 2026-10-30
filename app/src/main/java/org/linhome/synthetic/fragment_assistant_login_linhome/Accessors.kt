package org.linhome.synthetic.fragment_assistant_login_linhome

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.login get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.login)
val Dialog.login get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.login)
val Fragment.login get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.login)
val Activity.password get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Dialog.password get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Fragment.password get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Activity.username get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
val Dialog.username get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
val Fragment.username get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
