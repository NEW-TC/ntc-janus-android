package org.linhome.synthetic.fragment_assistant_login_sip.view

import android.view.View

val View.auth_id get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.auth_id)
val View.domain get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.domain)
val View.expiration get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.expiration)
val View.loginsip get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.loginsip)
val View.more get() = findViewById<org.linhome.ui.widgets.LRoundRectButtonWithIcon>(org.linhome.R.id.more)
val View.password get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val View.proxy get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.proxy)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val View.transport get() = findViewById<org.linhome.ui.widgets.LSegmentedControl>(org.linhome.R.id.transport)
val View.username get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
