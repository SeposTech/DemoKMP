package com.harshit.demokmp.connectivity

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ConnectivityObserverAndroid(
    private val context: Context
) : ConnectivityObserver {

    override val isConnected: Flow<Boolean> = callbackFlow {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(true) // Internet available
            }

            override fun onLost(network: Network) {
                trySend(false) // Internet lost
            }

            override fun onUnavailable() {
                trySend(false) // No network at all
            }
        }

        // Register callback (Android Lollipop+)
        connectivityManager.registerDefaultNetworkCallback(callback)

        // Cleanup when flow is closed
        awaitClose {
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }
}