package com.example.littlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun MyNavigation(navController: NavHostController, route: String) {
    NavHost(navController = navController, startDestination = route) {

        composable(Home.route) {
            Home(navController = navController)
        }

        composable(Onboarding.route) {
            Onboarding(navController = navController)
        }

        composable(Profile.route) {
            Profile(navController = navController)
        }
    }

}