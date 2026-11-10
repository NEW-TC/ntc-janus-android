package org.linhome.synthetic.fragment_account.view

import android.view.View

val View.account get() = findViewById<android.widget.TextView>(org.linhome.R.id.account)
val View.disconnect get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.disconnect)
val View.pushaccount get() = findViewById<android.widget.TextView>(org.linhome.R.id.pushaccount)
val View.refresh_registers get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.refresh_registers)
val View.background_settings get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.background_settings)
