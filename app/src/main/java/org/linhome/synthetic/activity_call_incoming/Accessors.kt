package org.linhome.synthetic.activity_call_incoming

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.buttons get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.buttons)
val Dialog.buttons get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.buttons)
val Fragment.buttons get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.buttons)
val Activity.chunk_call_name_address get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_name_address)
val Dialog.chunk_call_name_address get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_name_address)
val Fragment.chunk_call_name_address get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_name_address)
val Activity.chunk_call_top get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_top)
val Dialog.chunk_call_top get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_top)
val Fragment.chunk_call_top get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_top)
val Activity.chunk_call_video_or_icon get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Dialog.chunk_call_video_or_icon get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Fragment.chunk_call_video_or_icon get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Activity.chunk_some_text get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_some_text)
val Dialog.chunk_some_text get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_some_text)
val Fragment.chunk_some_text get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.chunk_some_text)
val Activity.middle get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.middle)
val Dialog.middle get() = findViewById<android.widget.RelativeLayout>(org.linhome.R.id.middle)
val Fragment.middle get() = requireView().findViewById<android.widget.RelativeLayout>(org.linhome.R.id.middle)
val Activity.videofullscreen get() = findViewById<android.view.TextureView>(org.linhome.R.id.videofullscreen)
val Dialog.videofullscreen get() = findViewById<android.view.TextureView>(org.linhome.R.id.videofullscreen)
val Fragment.videofullscreen get() = requireView().findViewById<android.view.TextureView>(org.linhome.R.id.videofullscreen)
val Activity.videotogglefullscreen get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglefullscreen)
val Dialog.videotogglefullscreen get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglefullscreen)
val Fragment.videotogglefullscreen get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglefullscreen)
