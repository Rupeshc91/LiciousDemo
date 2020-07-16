package com.android.liciousdemo.storage

import com.android.liciousdemo.model.Response

interface IStorage {
    fun execute(): Response
}