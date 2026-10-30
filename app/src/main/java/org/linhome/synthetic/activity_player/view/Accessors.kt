package org.linhome.synthetic.activity_player.view

import android.view.View

val View.audiomedia get() = findViewById<android.widget.ImageView>(org.linhome.R.id.audiomedia)
val View.cancel get() = findViewById<android.widget.ImageView>(org.linhome.R.id.cancel)
val View.controls get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.controls)
val View.video get() = findViewById<android.view.TextureView>(org.linhome.R.id.video)
