package com.harshit.demokmp.viewmodel

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.harshit.demokmp.navigation.NavHost
import com.harshit.demokmp.navigation.Route
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import com.harshit.demokmp.utils.PlatformLoginHelper

@Composable
fun AndroidLoginEntryPoint(platformLoginHelper: PlatformLoginHelper,storeListViewModel: AndroidStoreListViewModel, canNavigateBack: Boolean) {

    val backStack = remember { mutableStateListOf<Route>(Route.Login) }
    val context = LocalContext.current


    fun goBack() {
        if (backStack.size > 1) {
            backStack.removeAt(backStack.lastIndex)
        } else {
            (context as Activity).finish()
        }
    }

    BackHandler(enabled = backStack.size > 1) {
        goBack()
    }

    NavHost(
        backStack = backStack,
        onBackRequested = {
            (context as Activity).finish()
        },
        platformLoginHelper = platformLoginHelper,
        storeListHandler = storeListViewModel,
        canNavigateBack = canNavigateBack
    )
}