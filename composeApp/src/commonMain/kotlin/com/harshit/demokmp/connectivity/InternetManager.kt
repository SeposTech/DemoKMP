package com.harshit.demokmp.connectivity

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object InternetManager {
    var _isConnected = MutableStateFlow(false)
    val isConnected: StateFlow<Boolean> = _isConnected

    fun updateStatus(available: Boolean) {
        _isConnected.value = available
    }
}