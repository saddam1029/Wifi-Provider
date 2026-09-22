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
    ){
        composable("first"){
            FirstScreen(
                onFirstScreenClicked = { name ->
                    navController.navigate("second/$name")
                }
            )
        }

        composable("second/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            SecondScreen(
                name = name ?: "",
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}