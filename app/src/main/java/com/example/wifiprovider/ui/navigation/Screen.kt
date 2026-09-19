package com.example.wifiprovider.ui.navigation

import com.example.wifiprovider.R

sealed class Screen(val route: String, val title: String, val icon: Int) {
    object Home : Screen("home", "Home", R.drawable.ic_home)
    object WifiTools : Screen("wifi_tools", "Wifi Tools", R.drawable.ic_wifi_tools)
}
