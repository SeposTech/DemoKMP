package com.harshit.demokmp.viewmodel

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.harshit.demokmp.navigation.NavHost
import com.harshit.demokmp.navigation.Route

@Composable
fun AndroidLoginEntryPoint(viewmodel: AndroidLoginViewModel,canNavigateBack: Boolean){

    val backStack = remember { mutableStateListOf<Route>(Route.Login) }

    BackHandler(enabled = backStack.size > 1) {
        backStack.removeAt(backStack.lastIndex)
    }

    NavHost(
        backStack = backStack,
        onBackRequested = {
            // Optional: finish the activity or do nothing
        },
        viewmodel,
        canNavigateBack = canNavigateBack
    )
}