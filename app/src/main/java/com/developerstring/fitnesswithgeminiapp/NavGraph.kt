package com.developerstring.fitnesswithgeminiapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {


    NavHost(navController = navController, startDestination = "welcome_screen") {

        composable("welcome_screen") {
            WelcomeScreen(navController = navController)
        }

        composable("fitness_screen") {
            FitnessScreen()
        }

    }

}