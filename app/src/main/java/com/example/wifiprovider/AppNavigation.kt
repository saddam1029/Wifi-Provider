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
import androidx.compose.material3.NavigationBarItemDefaults
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

    val item = listOf(
        Screen.Home,
        Screen.Wifi,
        Screen.Settings
    )

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
                    item.forEach { screen ->
                        NavigationBarItem(
                            selected = currentDestination?.route == screen.route,
                            onClick = {
                                navController.navigate(screen.route){
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
                                    painter = painterResource(id = screen.icon),
                                    contentDescription = "Home"
                                )
                            },
                            label = {
                                Text(screen.title)
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color(0xFF007BFF),
                                selectedTextColor = Color(0xFF007BFF),
                                indicatorColor = Color.Transparent
                            )

                        )
                    }

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