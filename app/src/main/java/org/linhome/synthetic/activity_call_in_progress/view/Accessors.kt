package org.linhome.synthetic.activity_call_in_progress.view

import android.view.View

val View.actions get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.actions)
val View.call_timer get() = findViewById<android.widget.Chronometer>(org.linhome.R.id.call_timer)
val View.centerbundle get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.centerbundle)
val View.chunk_call_name_address get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_name_address)
val View.chunk_call_top get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_top)
val View.chunk_call_video_or_icon get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val View.controls get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.controls)
val View.timer get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.timer)
val View.videofullscreen get() = findViewById<android.view.TextureView>(org.linhome.R.id.videofullscreen)
val View.videotogglefullscreen get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglefullscreen)
