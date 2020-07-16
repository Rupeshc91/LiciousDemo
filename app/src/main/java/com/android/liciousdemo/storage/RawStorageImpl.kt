package com.android.liciousdemo.storage

import android.content.res.Resources
import com.android.liciousdemo.R
import com.android.liciousdemo.extensions.getRawTextFile
import com.android.liciousdemo.model.Response
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RawStorageImpl @Inject constructor(val resources: Resources) : IStorage {
    override fun execute(): Response {
        with(Dispatchers.Default) {
            val stringResponse = resources.getRawTextFile(R.raw.product_reorder)
            return Gson().fromJson(stringResponse, Response::class.java)
        }
    }
}