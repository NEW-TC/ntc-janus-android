package org.linhome.synthetic.chunk_player_controls

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.play get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.play)
val Dialog.play get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.play)
val Fragment.play get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.play)
val Activity.restart get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.restart)
val Dialog.restart get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.restart)
val Fragment.restart get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.restart)
val Activity.seek get() = findViewById<android.widget.SeekBar>(org.linhome.R.id.seek)
val Dialog.seek get() = findViewById<android.widget.SeekBar>(org.linhome.R.id.seek)
val Fragment.seek get() = requireView().findViewById<android.widget.SeekBar>(org.linhome.R.id.seek)
val Activity.timer get() = findViewById<android.widget.Chronometer>(org.linhome.R.id.timer)
val Dialog.timer get() = findViewById<android.widget.Chronometer>(org.linhome.R.id.timer)
val Fragment.timer get() = requireView().findViewById<android.widget.Chronometer>(org.linhome.R.id.timer)
