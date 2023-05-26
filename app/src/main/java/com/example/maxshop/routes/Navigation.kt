package com.example.maxshop.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.maxshop.presentation.HomeScreen
import com.example.maxshop.presentation.onboard.viewpage.OnBoardScreens

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.OnBoardingPage.route,
    ) {

        composable(route = Screens.OnBoardingPage.route) {
            OnBoardScreens(navController)
        }
        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen()
        }
    }
}