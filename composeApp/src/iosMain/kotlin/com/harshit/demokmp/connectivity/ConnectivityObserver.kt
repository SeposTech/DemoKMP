package com.harshit.demokmp.connectivity

import kotlinx.cinterop.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import platform.SystemConfiguration.*

actual class ConnectivityObserver {

    @OptIn(ExperimentalForeignApi::class)
    actual val isConnected: Boolean
        get() {
            val reachability = SCNetworkReachabilityCreateWithName(null, "www.google.com")
            val flagsVar = nativeHeap.alloc<UIntVar>()
            try {
                val success = SCNetworkReachabilityGetFlags(reachability, flagsVar.ptr)
                val flags = flagsVar.value.toInt()
                return success && (flags and kSCNetworkFlagsReachable.toInt() != 0)
            } finally {
                nativeHeap.free(flagsVar)
            }
        }
}