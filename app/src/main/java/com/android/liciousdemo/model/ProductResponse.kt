package com.android.liciousdemo.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("filters") val filters: List<Filter>,
    @SerializedName("products") val products: List<Product>
)
