package com.harshit.demokmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.interfaces.LoginHandler
import com.harshit.demokmp.navigation.NavHost
import com.harshit.demokmp.navigation.Route
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel

@Composable
fun iOSLoginEntryPoint(loginViewModel: LoginViewModel) {
    val backStack = remember { mutableStateListOf<Route>(Route.Login) }

    val loginHandler = object : LoginHandler {
        override fun login(request: UserLoginRequest) {
            // iOS login handling
        }
    }

    NavHost(
        backStack = backStack,
        onBackRequested = { /* iOS back handling */ },
        loginHandler = loginViewModel,
        canNavigateBack = false
    )
}