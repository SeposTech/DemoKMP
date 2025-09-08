package com.harshit.demokmp.navigation

sealed class Route {
    object Login : Route()
    object Registration: Route()
    object Home : Route()
    object Profile : Route()
    object Settings : Route()
}