package com.harshit.demokmp.application

import android.app.Application
import com.harshit.demokmp.androidDi.androidModule
import com.harshit.demokmp.connectivity.ConnectivityObserverAndroid
import com.harshit.demokmp.connectivity.InternetManager
import com.harshit.demokmp.di.commonModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val connectivityObserverAndroid = ConnectivityObserverAndroid(this)
        CoroutineScope(Dispatchers.Default).launch {
            connectivityObserverAndroid.isConnected.collect { available ->
                InternetManager.updateStatus(available)
            }
        }


        startKoin {
            androidContext(this@MyApp)
            modules(commonModule + androidModule)
        }
    }
}