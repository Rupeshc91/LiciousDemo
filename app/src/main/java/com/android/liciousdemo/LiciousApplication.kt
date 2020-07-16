package com.android.liciousdemo

import android.app.Activity
import android.app.Application
import com.android.liciousdemo.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LiciousApplication : Application(), HasActivityInjector {

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

}