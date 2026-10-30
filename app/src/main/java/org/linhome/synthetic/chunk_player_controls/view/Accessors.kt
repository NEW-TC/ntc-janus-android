package org.linhome.synthetic.chunk_player_controls.view

import android.view.View

val View.play get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.play)
val View.restart get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.restart)
val View.seek get() = findViewById<android.widget.SeekBar>(org.linhome.R.id.seek)
val View.timer get() = findViewById<android.widget.Chronometer>(org.linhome.R.id.timer)
