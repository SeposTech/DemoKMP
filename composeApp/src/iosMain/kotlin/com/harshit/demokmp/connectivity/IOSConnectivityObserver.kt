package com.harshit.demokmp.connectivity

import kotlinx.coroutines.flow.Flow

class IOSConnectivityObserver {

    fun setStatus(available: Boolean) {
        InternetManager.updateStatus(available)

        // Direct print
        println("IOSConnectivityObserver received status: $available")
    }

    fun getFlow(): Flow<Boolean> = InternetManager.isConnected
}