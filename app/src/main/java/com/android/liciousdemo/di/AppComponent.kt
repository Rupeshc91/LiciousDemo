package com.android.liciousdemo.di

import android.app.Application
import com.android.liciousdemo.LiciousApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, DataModule::class,ActivityModule::class,FragmentModule::class, AndroidInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(application: LiciousApplication)
}