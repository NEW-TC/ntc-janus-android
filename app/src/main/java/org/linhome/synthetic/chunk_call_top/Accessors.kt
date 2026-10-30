package org.linhome.synthetic.chunk_call_top

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.icons get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.icons)
val Dialog.icons get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.icons)
val Fragment.icons get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.icons)
