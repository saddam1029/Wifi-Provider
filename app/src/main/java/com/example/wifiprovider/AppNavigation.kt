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
                onFirstScreenClicked = { name,age ->
                    navController.navigate("second/$name/$age")
                }
            )
        }

        composable("second/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val age = backStackEntry.arguments?.getString("age")
            SecondScreen(
                name = name ?: "",
                age = age?.toIntOrNull() ?: 0,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}