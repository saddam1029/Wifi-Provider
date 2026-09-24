package com.example.wifiprovider

sealed class Screen(
    val route: String,
    val title: String
) {

    object Home: Screen(
        route = "home",
        title = "Home"
    )
    object Wifi: Screen(
        route = "wifi",
        title = "Wifi"
    )
    object Settings: Screen(
        route = "settings",
        title = "Settings"
    )

}