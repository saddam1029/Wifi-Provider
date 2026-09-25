package com.example.wifiprovider

import androidx.annotation.DrawableRes

// sealed class provides limited number of Possibilities like home, wifi and settings
sealed class Screen(
    val route: String,
    val title: String,
    @DrawableRes val icon:Int
) {

    object Home: Screen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home
    )
    object Wifi: Screen(
        route = "wifi",
        title = "Wifi",
        icon = R.drawable.ic_wifi
    )
    object Settings: Screen(
        route = "settings",
        title = "Settings",
        icon = R.drawable.ic_setting
    )

}