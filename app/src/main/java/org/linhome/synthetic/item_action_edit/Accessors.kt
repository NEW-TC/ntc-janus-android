package org.linhome.synthetic.item_action_edit

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.code get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.code)
val Dialog.code get() = findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.code)
val Fragment.code get() = requireView().findViewById<org.linhome.ui.widgets.LTextInput>(org.linhome.R.id.code)
val Activity.list_item get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.list_item)
val Dialog.list_item get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.list_item)
val Fragment.list_item get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.list_item)
val Activity.trash get() = findViewById<android.widget.ImageView>(org.linhome.R.id.trash)
val Dialog.trash get() = findViewById<android.widget.ImageView>(org.linhome.R.id.trash)
val Fragment.trash get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.trash)
val Activity.type get() = findViewById<org.linhome.ui.widgets.LSpinner>(org.linhome.R.id.type)
val Dialog.type get() = findViewById<org.linhome.ui.widgets.LSpinner>(org.linhome.R.id.type)
val Fragment.type get() = requireView().findViewById<org.linhome.ui.widgets.LSpinner>(org.linhome.R.id.type)
