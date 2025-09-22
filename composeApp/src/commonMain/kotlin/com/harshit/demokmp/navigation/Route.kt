package com.harshit.demokmp.navigation

sealed class Route {
    object Login : Route()
    object Registration: Route()
    object SelectionType: Route()

    object StoreList: Route()
    data class Category(val vendorId: String?): Route()
}