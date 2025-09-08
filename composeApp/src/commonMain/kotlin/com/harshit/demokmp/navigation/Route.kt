package com.harshit.demokmp.navigation

sealed class Route {
    object Login : Route()
    object Registration: Route()
    object SelectionType: Route()
}