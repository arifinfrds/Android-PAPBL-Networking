package com.arifinfrds.papblnetworking.extension

import android.content.Context
import android.widget.Toast

/**
 * Created by arifinfrds on 3/9/18.
 */

fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()