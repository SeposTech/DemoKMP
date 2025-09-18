package com.harshit.demokmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.harshit.demokmp.navigation.NavHost
import com.harshit.demokmp.navigation.Route
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel

@Composable
fun iOSLoginEntryPoint(loginViewModel: LoginViewModel,storeListViewModel: StoreListViewModel) {
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
        loginHandler = loginViewModel,
        storeListHandler = storeListViewModel,
        canNavigateBack = false
    )
}