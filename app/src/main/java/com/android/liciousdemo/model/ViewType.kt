package com.android.liciousdemo.model

interface ViewType<out T> {
    val type: Int
    val data: T
}