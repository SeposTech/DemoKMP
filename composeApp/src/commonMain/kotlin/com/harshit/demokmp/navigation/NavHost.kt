package com.harshit.demokmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.harshit.demokmp.presentation.screens.LoginPage
import com.harshit.demokmp.presentation.screens.RegistrationPage
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.harshit.demokmp.interfaces.LoginHandler
import com.harshit.demokmp.presentation.screens.SelectionTypePage
import com.harshit.demokmp.presentation.screens.ShowLoginPage


@Composable
fun NavHost(
    backStack: SnapshotStateList<Route> = remember { mutableStateListOf(Route.Login) },
    onBackRequested: () -> Unit,
    loginHandler: LoginHandler,
    canNavigateBack: Boolean
) {

    val currentScreen = backStack.last()

    fun navigateTo(screen: Route) {
        backStack.add(screen)
    }

    fun goBack() {
        if (backStack.size > 1) {
            backStack.removeLast()
        } else {
            onBackRequested()
        }
    }
    when (currentScreen) {
        Route.Login -> ShowLoginPage(onNavigate = { navigateTo(it) },loginHandler,canNavigateBack)
        Route.Registration -> RegistrationPage(
            onNavigate = { navigateTo(it) },
            onBack = { goBack() })

        Route.SelectionType -> SelectionTypePage(
            onNavigate = { navigateTo(it) },
            onBack = { goBack() }
        )
    }
}