package com.android.liciousdemo.data

import com.android.liciousdemo.model.Response
import javax.inject.Singleton

@Singleton
class LocalDataSource : ILocalDataSource {
    override suspend fun getProducts(block: () -> Response): Response {
        return block()
    }
}