package com.harshit.demokmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.harshit.demokmp.presentation.screens.RegistrationPage
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.harshit.demokmp.presentation.screens.SelectionTypePage
import com.harshit.demokmp.presentation.screens.ShowLoginPage
import com.harshit.demokmp.presentation.screens.StoreListPage
import com.harshit.demokmp.utils.PlatformLoginHelper
import com.harshit.demokmp.utils.PlatformStoreListHelper


@Composable
fun NavHost(
    backStack: SnapshotStateList<Route> = remember { mutableStateListOf(Route.Login) },
    onBackRequested: () -> Unit,
    platformLoginHelper: PlatformLoginHelper,
    platformStoreListHelper: PlatformStoreListHelper,
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
        Route.Login -> ShowLoginPage(
            onNavigate = { navigateTo(it) },
            platformLoginHelper = platformLoginHelper,
            canNavigateBack,
            onBack = { goBack() })

        Route.Registration -> RegistrationPage(
            onNavigate = { navigateTo(it) },
            onBack = { goBack() })

        Route.SelectionType -> SelectionTypePage(
            onNavigate = { navigateTo(it) },
            onBack = { goBack() }
        )

        Route.StoreList -> StoreListPage(
        platformStoreListHelper = platformStoreListHelper
        )


    }
}