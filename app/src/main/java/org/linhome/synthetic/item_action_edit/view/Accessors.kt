package org.linhome.synthetic.item_action_edit.view

import android.view.View

val View.code get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.code)
val View.list_item get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.list_item)
val View.trash get() = findViewById<android.widget.ImageView>(org.linhome.R.id.trash)
val View.type get() = findViewById<org.linhome.ui.widgets.LSpinner>(org.linhome.R.id.type)
