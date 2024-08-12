package com.example.appslist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appslist.presentation.ui.detailscreen.DetailsScreen
import com.example.appslist.presentation.ui.homescreen.HomeScreen

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "/") {
        composable("/") {
            HomeScreen(
                onAppSelected = {
                    navController.navigate("/movie/${it}")
                }
            )
        }
        composable(
            route = "/movie/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                }
            )
        ) {
            DetailsScreen(
                /*backAction = {
                    navController.popBackStack()
                    navController.navigate("/")
                }*/
            )
        }
    }
}
