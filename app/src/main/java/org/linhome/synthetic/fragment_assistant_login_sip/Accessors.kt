package org.linhome.synthetic.fragment_assistant_login_sip

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.auth_id get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.auth_id)
val Dialog.auth_id get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.auth_id)
val Fragment.auth_id get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.auth_id)
val Activity.domain get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.domain)
val Dialog.domain get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.domain)
val Fragment.domain get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.domain)
val Activity.expiration get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.expiration)
val Dialog.expiration get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.expiration)
val Fragment.expiration get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.expiration)
val Activity.loginsip get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.loginsip)
val Dialog.loginsip get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.loginsip)
val Fragment.loginsip get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.loginsip)
val Activity.more get() = findViewById<org.linhome.ui.widgets.LRoundRectButtonWithIcon>(org.linhome.R.id.more)
val Dialog.more get() = findViewById<org.linhome.ui.widgets.LRoundRectButtonWithIcon>(org.linhome.R.id.more)
val Fragment.more get() = requireView().findViewById<org.linhome.ui.widgets.LRoundRectButtonWithIcon>(org.linhome.R.id.more)
val Activity.password get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Dialog.password get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Fragment.password get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val Activity.proxy get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.proxy)
val Dialog.proxy get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.proxy)
val Fragment.proxy get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.proxy)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Activity.transport get() = findViewById<org.linhome.ui.widgets.LSegmentedControl>(org.linhome.R.id.transport)
val Dialog.transport get() = findViewById<org.linhome.ui.widgets.LSegmentedControl>(org.linhome.R.id.transport)
val Fragment.transport get() = requireView().findViewById<org.linhome.ui.widgets.LSegmentedControl>(org.linhome.R.id.transport)
val Activity.username get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
val Dialog.username get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
val Fragment.username get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
