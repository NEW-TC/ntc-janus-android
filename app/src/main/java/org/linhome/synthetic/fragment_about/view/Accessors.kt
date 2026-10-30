package org.linhome.synthetic.fragment_about.view

import android.view.View

val View.appversion get() = findViewById<android.widget.TextView>(org.linhome.R.id.appversion)
val View.copyright get() = findViewById<android.widget.TextView>(org.linhome.R.id.copyright)
val View.licence get() = findViewById<android.widget.TextView>(org.linhome.R.id.licence)
val View.linhome_icon get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_icon)
val View.linhome_link get() = findViewById<android.widget.TextView>(org.linhome.R.id.linhome_link)
val View.linhome_text get() = findViewById<android.widget.ImageView>(org.linhome.R.id.linhome_text)
val View.linhome_title get() = findViewById<android.widget.TextView>(org.linhome.R.id.linhome_title)
val View.screen get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.screen)
val View.sdkversion get() = findViewById<android.widget.TextView>(org.linhome.R.id.sdkversion)
val View.texts get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.texts)
