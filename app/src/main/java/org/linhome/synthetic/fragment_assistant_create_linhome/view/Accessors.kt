package org.linhome.synthetic.fragment_assistant_create_linhome.view

import android.view.View

val View.create get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.create)
val View.email get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.email)
val View.password get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password)
val View.password_confirmation get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.password_confirmation)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val View.username get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.username)
