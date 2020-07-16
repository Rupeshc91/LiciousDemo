package com.android.liciousdemo.model

import com.google.gson.annotations.SerializedName

data class ProductMerchantdising(
    @SerializedName("product_shortname") val productShortName: String,
    @SerializedName("product_delivery_type") val deliveryType: String,
    @SerializedName("pr_image") val image: String
)