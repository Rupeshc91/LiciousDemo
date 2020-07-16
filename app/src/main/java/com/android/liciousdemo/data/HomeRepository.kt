package com.android.liciousdemo.data

import com.android.liciousdemo.model.ProductResponse

interface HomeRepository {

    suspend fun getProducts(): ProductResponse

}