package com.android.liciousdemo.model

import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("type") val type: String,
    @SerializedName("title") val title:String
)