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
                onNavigateToSecondScreen = {text ->
                    navController.navigate("second/$text")
                }
            )
        }

        composable("second/{text}") {  it ->

            val text = it.arguments?.getString("text")

            SecondScreen (
                text = text ?: "",
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}