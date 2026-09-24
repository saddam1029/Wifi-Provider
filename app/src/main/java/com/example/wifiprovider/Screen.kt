package com.example.wifiprovider

// sealed class provides limited number of Possibilities like home, wifi and settings
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