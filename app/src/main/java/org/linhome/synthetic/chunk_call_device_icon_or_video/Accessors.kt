package org.linhome.synthetic.chunk_call_device_icon_or_video

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.chunk_call_video_or_icon get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Dialog.chunk_call_video_or_icon get() = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Fragment.chunk_call_video_or_icon get() = requireView().findViewById<androidx.constraintlayout.widget.ConstraintLayout>(org.linhome.R.id.chunk_call_video_or_icon)
val Activity.videocollapsed get() = findViewById<android.view.TextureView>(org.linhome.R.id.videocollapsed)
val Dialog.videocollapsed get() = findViewById<android.view.TextureView>(org.linhome.R.id.videocollapsed)
val Fragment.videocollapsed get() = requireView().findViewById<android.view.TextureView>(org.linhome.R.id.videocollapsed)
val Activity.videotogglecollapsed get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglecollapsed)
val Dialog.videotogglecollapsed get() = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglecollapsed)
val Fragment.videotogglecollapsed get() = requireView().findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(org.linhome.R.id.videotogglecollapsed)
