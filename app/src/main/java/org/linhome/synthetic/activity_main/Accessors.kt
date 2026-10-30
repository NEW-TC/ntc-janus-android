package org.linhome.synthetic.activity_main

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.drawer_layout get() = findViewById<androidx.drawerlayout.widget.DrawerLayout>(org.linhome.R.id.drawer_layout)
val Dialog.drawer_layout get() = findViewById<androidx.drawerlayout.widget.DrawerLayout>(org.linhome.R.id.drawer_layout)
val Fragment.drawer_layout get() = requireView().findViewById<androidx.drawerlayout.widget.DrawerLayout>(org.linhome.R.id.drawer_layout)
