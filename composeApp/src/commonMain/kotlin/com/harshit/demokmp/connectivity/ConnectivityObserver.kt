package com.harshit.demokmp.connectivity

import kotlinx.coroutines.flow.Flow

expect class ConnectivityObserver{
    val isConnected: Boolean
}