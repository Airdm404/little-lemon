package com.example.littlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, startDestination: String, database: AppDatabase) {

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Onboarding.route) { Onboarding(navController) }
        composable(Home.route) { Home(navController, database) }
        composable(Profile.route) { Profile(navController) }

    }
}

