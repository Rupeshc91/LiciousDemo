package com.android.liciousdemo.model

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.liciousdemo.R
import com.android.liciousdemo.extensions.loadImage
import com.google.gson.annotations.SerializedName

@BindingAdapter("image")
fun bindImage(imageView: ImageView, productMercahntdising: ProductMerchantdising) {
    productMercahntdising.image.let {
        imageView.loadImage(it)
    }
}

@BindingAdapter("title")
fun bindTitle(textView: TextView, title: String) {
    textView.text = title.trim()
}

class Product(
    @SerializedName("product_master") val productMaster: ProductMaster,
    @SerializedName("product_merchantdising") val productMercahntdising: ProductMerchantdising
) : ViewType<Product> {
    override val type: Int
        get() = R.layout.view_product_item
    override val data: Product
        get() = this

}