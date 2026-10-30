package org.linhome.synthetic.call_incoming_notification_content_with_snapshot.view

import android.view.View

val View.caller get() = findViewById<android.widget.TextView>(org.linhome.R.id.caller)
val View.caller_picture get() = findViewById<android.widget.ImageView>(org.linhome.R.id.caller_picture)
val View.device_type get() = findViewById<android.widget.ImageView>(org.linhome.R.id.device_type)
val View.header get() = findViewById<android.widget.LinearLayout>(org.linhome.R.id.header)
val View.incoming_call_info get() = findViewById<android.widget.TextView>(org.linhome.R.id.incoming_call_info)
