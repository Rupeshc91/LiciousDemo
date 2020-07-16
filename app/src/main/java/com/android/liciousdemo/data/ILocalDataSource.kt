package com.android.liciousdemo.data

import com.android.liciousdemo.model.Response

interface ILocalDataSource {

    suspend fun getProducts(block:()->Response): Response
}