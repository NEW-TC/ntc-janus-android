package org.linhome.synthetic.call_incoming_notification_content_with_snapshot

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment

val Activity.caller get() = findViewById<android.widget.TextView>(org.linhome.R.id.caller)
val Dialog.caller get() = findViewById<android.widget.TextView>(org.linhome.R.id.caller)
val Fragment.caller get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.caller)
val Activity.caller_picture get() = findViewById<android.widget.ImageView>(org.linhome.R.id.caller_picture)
val Dialog.caller_picture get() = findViewById<android.widget.ImageView>(org.linhome.R.id.caller_picture)
val Fragment.caller_picture get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.caller_picture)
val Activity.device_type get() = findViewById<android.widget.ImageView>(org.linhome.R.id.device_type)
val Dialog.device_type get() = findViewById<android.widget.ImageView>(org.linhome.R.id.device_type)
val Fragment.device_type get() = requireView().findViewById<android.widget.ImageView>(org.linhome.R.id.device_type)
val Activity.header get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.header)
val Dialog.header get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.header)
val Fragment.header get() = requireView().findViewById<android.widget.LinearLayout>(org.linhome.R.id.header)
val Activity.incoming_call_info get() = findViewById<android.widget.TextView>(org.linhome.R.id.incoming_call_info)
val Dialog.incoming_call_info get() = findViewById<android.widget.TextView>(org.linhome.R.id.incoming_call_info)
val Fragment.incoming_call_info get() = requireView().findViewById<android.widget.TextView>(org.linhome.R.id.incoming_call_info)
