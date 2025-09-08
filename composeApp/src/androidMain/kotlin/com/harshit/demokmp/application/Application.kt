package com.harshit.demokmp.application

import android.app.Application
import com.harshit.demokmp.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(commonModule)
        }
    }
}