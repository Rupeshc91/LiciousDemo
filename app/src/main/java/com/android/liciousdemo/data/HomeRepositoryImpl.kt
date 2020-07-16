package com.android.liciousdemo.data

import com.android.liciousdemo.model.ProductResponse
import com.android.liciousdemo.storage.IStorage
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    val localDataSource: ILocalDataSource,
    val storage: IStorage
) :
    HomeRepository {
    override suspend fun getProducts(): ProductResponse {
        val result = localDataSource.getProducts {
            storage.execute()
        }
        return result.data
    }
}