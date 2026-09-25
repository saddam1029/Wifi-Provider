package com.example.wifiprovider

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xFFD7E8FD)
                ),
                color = Color.White,
                tonalElevation = 0.dp,
                shadowElevation = 0.dp
            )
            {
                NavigationBar(
                    containerColor = Color.Transparent,
                    tonalElevation = 0.dp
                )  {
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
                            Icon(
                                painter = painterResource(id = R.drawable.ic_home),
                                contentDescription = "Home"
                            )
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
                            Icon(
                                painter = painterResource(id = R.drawable.ic_wifi),
                                contentDescription = "wifi"
                            )
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
                            Icon(
                                painter = painterResource(id = R.drawable.ic_setting),
                                contentDescription = "setting"
                            )
                        },
                        label = {
                            Text("Settings")
                        }
                    )

                }
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