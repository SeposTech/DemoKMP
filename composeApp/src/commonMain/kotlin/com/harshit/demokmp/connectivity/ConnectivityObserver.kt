package com.harshit.demokmp.connectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver{
    val isConnected: Flow<Boolean>
}