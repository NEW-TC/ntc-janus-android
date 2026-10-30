package org.linhome.synthetic.activity_call_incoming.view

import android.view.View

val View.buttons get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.buttons)
val View.chunk_call_name_address get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_name_address)
val View.chunk_call_top get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_top)
val View.chunk_call_video_or_icon get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val View.chunk_some_text get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_some_text)
val View.middle get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.middle)
val View.videofullscreen get() = findViewById<android.view.TextureView>(org.linhome.R.id.videofullscreen)
val View.videotogglefullscreen get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglefullscreen)
