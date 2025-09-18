package com.harshit.demokmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.harshit.demokmp.navigation.NavHost
import com.harshit.demokmp.navigation.Route
import com.harshit.demokmp.utils.PlatformLoginHelper
import com.harshit.demokmp.utils.PlatformStoreListHelper

@Composable
fun iOSLoginEntryPoint(platformLoginHelper: PlatformLoginHelper,platformStoreListHelper: PlatformStoreListHelper) {
    val backStack = remember { mutableStateListOf<Route>(Route.Login) }

    fun goBack() {
        if (backStack.size > 1) {
            backStack.removeAt(backStack.lastIndex)
        } else {

        }
    }

    NavHost(
        backStack = backStack,
        onBackRequested = {goBack()},
        platformLoginHelper = platformLoginHelper,
        platformStoreListHelper = platformStoreListHelper,
        canNavigateBack = false
    )
}