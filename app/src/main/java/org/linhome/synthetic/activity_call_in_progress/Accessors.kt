package org.linhome.synthetic.activity_call_in_progress

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.actions get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.actions)
val Dialog.actions get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.actions)
val Fragment.actions get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.actions)
val Activity.call_timer get() = findViewById<android.widget.Chronometer>(org.linhome.R.id.call_timer)
val Dialog.call_timer get() = findViewById<android.widget.Chronometer>(org.linhome.R.id.call_timer)
val Fragment.call_timer get() = requireView().findViewById<android.widget.Chronometer>(org.linhome.R.id.call_timer)
val Activity.centerbundle get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.centerbundle)
val Dialog.centerbundle get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.centerbundle)
val Fragment.centerbundle get() = requireView().findViewById<android.widget.RelativeLayout>(org.linhome.R.id.centerbundle)
val Activity.chunk_call_name_address get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_name_address)
val Dialog.chunk_call_name_address get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_name_address)
val Fragment.chunk_call_name_address get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_name_address)
val Activity.chunk_call_top get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_top)
val Dialog.chunk_call_top get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_top)
val Fragment.chunk_call_top get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_top)
val Activity.chunk_call_video_or_icon get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Dialog.chunk_call_video_or_icon get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Fragment.chunk_call_video_or_icon get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Activity.controls get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.controls)
val Dialog.controls get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.controls)
val Fragment.controls get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.controls)
val Activity.timer get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.timer)
val Dialog.timer get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.timer)
val Fragment.timer get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.timer)
val Activity.videofullscreen get() = findViewById<android.view.TextureView>(org.linhome.R.id.videofullscreen)
val Dialog.videofullscreen get() = findViewById<android.view.TextureView>(org.linhome.R.id.videofullscreen)
val Fragment.videofullscreen get() = requireView().findViewById<android.view.TextureView>(org.linhome.R.id.videofullscreen)
val Activity.videotogglefullscreen get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglefullscreen)
val Dialog.videotogglefullscreen get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglefullscreen)
val Fragment.videotogglefullscreen get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglefullscreen)
