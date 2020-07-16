package com.android.liciousdemo.model

import com.google.gson.annotations.SerializedName

 class Response(
     @SerializedName("statusCode") val statusCode: Int,
     @SerializedName("statusMessage") val statusMessage: String,
     @SerializedName("data") val data: ProductResponse
)