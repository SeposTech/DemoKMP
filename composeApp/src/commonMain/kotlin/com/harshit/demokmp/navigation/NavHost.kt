package com.harshit.demokmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.harshit.demokmp.ui.screens.LoginPage
import com.harshit.demokmp.ui.screens.RegistrationPage
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.harshit.demokmp.ui.screens.SelectionTypePage


@Composable
fun NavHost(
    backStack: SnapshotStateList<Route> = remember { mutableStateListOf(Route.Login) },
    onBackRequested: () -> Unit
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
        Route.Login -> LoginPage(onNavigate = { navigateTo(it) })
        Route.Registration -> RegistrationPage(
            onNavigate = { navigateTo(it) },
            onBack = { goBack() })

        Route.SelectionType -> SelectionTypePage(
            onNavigate = { navigateTo(it) },
            onBack = { goBack() }
        )
    }
}