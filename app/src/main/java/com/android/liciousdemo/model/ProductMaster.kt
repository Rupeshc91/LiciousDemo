package com.android.liciousdemo.model

import com.google.gson.annotations.SerializedName

data class ProductMaster(
    @SerializedName("pr_name") val name: String,
    @SerializedName("net") val net: String
)