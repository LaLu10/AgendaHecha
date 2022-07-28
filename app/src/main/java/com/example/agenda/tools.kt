package com.example.agenda

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment

fun Fragment.toast(text:String, length:Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.context, text, length).show()
}

