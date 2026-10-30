package org.linhome.synthetic.chunk_call_in_progress_actions

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.action1 get() = findViewById<android.view.View>(org.linhome.R.id.action1)
val Dialog.action1 get() = findViewById<android.view.View>(org.linhome.R.id.action1)
val Fragment.action1 get() = requireView().findViewById<android.view.View>(org.linhome.R.id.action1)
