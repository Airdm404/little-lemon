package com.example.littlelemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    private val sharedPreferences by lazy {
        getSharedPreferences("LittleLemonUserInfo", MODE_PRIVATE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")

        val isUserLoggedIn = (sharedPreferences.contains("firstName") &&
                sharedPreferences.contains("lastName") &&
                sharedPreferences.contains("email"))


        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                val destination = if (isUserLoggedIn) "Home" else "Onboarding"
                NavHost(navController = navController, startDestination = destination) {

                    composable(route = Home.route) {
                        Home(navController = navController)
                    }

                    composable(route = Onboarding.route) {
                        Onboarding(navController = navController)
                    }

                    composable(route = Profile.route) {
                        Profile(navController = navController)
                    }
                }
            }
        }
    }
}

