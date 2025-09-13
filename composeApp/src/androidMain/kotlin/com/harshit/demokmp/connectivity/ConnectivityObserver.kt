package com.harshit.demokmp.connectivity

import android.content.Context
import android.net.ConnectivityManager

actual class ConnectivityObserver(
    private val context: Context
) {
    actual val isConnected: Boolean
        get() {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network = connectivityManager.activeNetwork
            return network != null
        }
}