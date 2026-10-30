package org.linhome.synthetic.widget_segmented_control

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.buttons get() = findViewById<com.google.android.material.button.MaterialButtonToggleGroup>(org.linhome.R.id.buttons)
val Dialog.buttons get() = findViewById<com.google.android.material.button.MaterialButtonToggleGroup>(org.linhome.R.id.buttons)
val Fragment.buttons get() = requireView().findViewById<com.google.android.material.button.MaterialButtonToggleGroup>(org.linhome.R.id.buttons)
val Activity.error get() = findViewById<android.widget.TextView>(org.linhome.R.id.error)
val Dialog.error get() = findViewById<android.widget.TextView>(org.linhome.R.id.error)
val Fragment.error get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.error)
val Activity.option1 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option1)
val Dialog.option1 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option1)
val Fragment.option1 get() = requireView().findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option1)
val Activity.option2 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option2)
val Dialog.option2 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option2)
val Fragment.option2 get() = requireView().findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option2)
val Activity.option3 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option3)
val Dialog.option3 get() = findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option3)
val Fragment.option3 get() = requireView().findViewById<com.google.android.material.button.MaterialButton>(org.linhome.R.id.option3)
val Activity.root get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.root)
val Dialog.root get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.root)
val Fragment.root get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.root)
val Activity.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Dialog.title get() = findViewById<android.widget.TextView>(org.linhome.R.id.title)
val Fragment.title get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.title)
