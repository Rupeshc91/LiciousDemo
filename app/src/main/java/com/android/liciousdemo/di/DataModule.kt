package com.android.liciousdemo.di

import android.app.Application
import com.android.liciousdemo.data.HomeRepository
import com.android.liciousdemo.data.HomeRepositoryImpl
import com.android.liciousdemo.data.ILocalDataSource
import com.android.liciousdemo.data.LocalDataSource
import com.android.liciousdemo.storage.IStorage
import com.android.liciousdemo.storage.RawStorageImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesLocalDataSource(): ILocalDataSource = LocalDataSource()


    @Provides
    @Singleton
    fun providesStorage(application: Application): IStorage = RawStorageImpl(application.resources)

    @Provides
    @Singleton
    fun providesHomeRepository(iLocalDataSource: ILocalDataSource, iStorage: IStorage):HomeRepository =
        HomeRepositoryImpl(iLocalDataSource, iStorage)

}