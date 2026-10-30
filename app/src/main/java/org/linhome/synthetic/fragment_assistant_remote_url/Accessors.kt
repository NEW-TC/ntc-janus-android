package org.linhome.synthetic.fragment_assistant_remote_url

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.apply get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.apply)
val Dialog.apply get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.apply)
val Fragment.apply get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.apply)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Activity.url get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.url)
val Dialog.url get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.url)
val Fragment.url get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.url)
