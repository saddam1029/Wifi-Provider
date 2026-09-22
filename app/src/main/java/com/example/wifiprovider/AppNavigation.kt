package com.example.wifiprovider

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wifiprovider.ui.MainScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "first"
    ) {

        composable("first") {
            FirstScreen(
                onNavigateToSecondScreen = {
                    navController.navigate("second")
                }
            )
        }

        composable("second") {
            SecondScreen (
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}