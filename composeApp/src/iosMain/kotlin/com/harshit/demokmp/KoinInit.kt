package com.harshit.demokmp

import org.koin.core.context.startKoin
import com.harshit.demokmp.iosDi.iosModule
import org.koin.core.KoinApplication

// iOS compatible KoinApplication
lateinit var koinApp: KoinApplication

fun initKoinOnce() {
    // Start Koin and assign to koinApp
    if (!::koinApp.isInitialized) { // Check if koinApp is already initialized
        koinApp = startKoin {
            modules(listOf(iosModule)) // your iOS module
        }
    }
}