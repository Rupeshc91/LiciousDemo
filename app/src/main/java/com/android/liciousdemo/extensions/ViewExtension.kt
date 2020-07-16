package com.android.liciousdemo.extensions

import android.content.res.Resources
import android.widget.ImageView
import androidx.annotation.RawRes
import com.android.liciousdemo.GlideApp
import com.android.liciousdemo.R

fun ImageView.loadImage(url: String, placeholder: Int = R.color.colorPrimary) {
    GlideApp.with(context).load(url).placeholder(placeholder).into(this)
}

fun Resources.getRawTextFile(@RawRes id: Int) =
    openRawResource(id).bufferedReader().use { it.readText() }

