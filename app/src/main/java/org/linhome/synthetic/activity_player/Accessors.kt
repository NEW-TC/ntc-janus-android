package org.linhome.synthetic.activity_player

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.audiomedia get() = findViewById<android.widget.ImageView>(org.linhome.R.id.audiomedia)
val Dialog.audiomedia get() = findViewById<android.widget.ImageView>(org.linhome.R.id.audiomedia)
val Fragment.audiomedia get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.audiomedia)
val Activity.cancel get() = findViewById<android.widget.ImageView>(org.linhome.R.id.cancel)
val Dialog.cancel get() = findViewById<android.widget.ImageView>(org.linhome.R.id.cancel)
val Fragment.cancel get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.cancel)
val Activity.controls get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.controls)
val Dialog.controls get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.controls)
val Fragment.controls get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.controls)
val Activity.video get() = findViewById<android.view.TextureView>(org.linhome.R.id.video)
val Dialog.video get() = findViewById<android.view.TextureView>(org.linhome.R.id.video)
val Fragment.video get() = requireView().findViewById<android.view.TextureView>(org.linhome.R.id.video)
