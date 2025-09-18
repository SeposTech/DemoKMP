package com.harshit.demokmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.harshit.demokmp.navigation.NavHost
import com.harshit.demokmp.navigation.Route
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import com.harshit.demokmp.utils.PlatformLoginHelper

@Composable
fun iOSLoginEntryPoint(platformLoginHelper: PlatformLoginHelper,storeListViewModel: StoreListViewModel) {
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
        storeListHandler = storeListViewModel,
        canNavigateBack = false
    )
}