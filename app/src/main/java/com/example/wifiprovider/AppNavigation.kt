package com.example.wifiprovider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentDestination?.route == Screen.Home.route,
                    onClick = {
                        navController.navigate(Screen.Home.route){
                            popUpTo(
                                navController.graph.startDestinationId
                            ){
                                saveState = true
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Text("🏠")
                    },
                    label = {
                        androidx.compose.material3.Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = currentDestination?.route == Screen.Wifi.route,
                    onClick = {
                        navController.navigate(Screen.Wifi.route){
                            popUpTo(
                                navController.graph.startDestinationId
                            ){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Text("📶")
                    },
                    label = {
                        Text("Wi-Fi")
                    }
                )

                NavigationBarItem(
                    selected = currentDestination?.route == Screen.Settings.route,
                    onClick = {
                        navController.navigate(Screen.Settings.route){
                            popUpTo(
                                navController.graph.startDestinationId
                            ){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Text("⚙️")
                    },
                    label = {
                        Text("Settings")
                    }
                )

            }
        }

    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        )
        {
            composable(Screen.Home.route) {
                HomeScreen()
            }

            composable(Screen.Wifi.route) {
                WifiScreen()
            }

            composable(Screen.Settings.route) {
                SettingsScreen()
            }

        }
    }
}