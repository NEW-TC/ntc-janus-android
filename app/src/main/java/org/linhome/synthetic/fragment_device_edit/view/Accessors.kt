package org.linhome.synthetic.fragment_device_edit.view

import android.view.View

val View.actions get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.actions)
val View.addaction get() = findViewById<org.linhome.ui.widgets.LRoundRectButtonWithIcon>(org.linhome.R.id.addaction)
val View.address get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.address)
val View.delete get() = findViewById<org.linhome.ui.widgets.LRoundRectButton>(org.linhome.R.id.delete)
val View.devicetype get() = findViewById<org.linhome.ui.widgets.LSpinner>(org.linhome.R.id.devicetype)
val View.method get() = findViewById<org.linhome.ui.widgets.LSpinner>(org.linhome.R.id.method)
val View.name get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.name)
val View.select_method_section_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.select_method_section_title)
val View.select_type_section_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.select_type_section_title)
val View.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val View.your_device get() = findViewById<android.widget.TextView>(org.linhome.R.id.your_device)
