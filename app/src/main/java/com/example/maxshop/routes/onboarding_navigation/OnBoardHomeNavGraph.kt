package com.example.maxshop.routes.onboarding_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.maxshop.presentation.screens.homescreen.HomeScreen
import com.example.maxshop.presentation.screens.onboard.viewpage.OnBoardScreens
import com.example.maxshop.routes.OnBoardingAndHomeScreen

@Composable
fun OnBoardHomeNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = OnBoardingAndHomeScreen.OnBoardingPage.route,
    ) {

        composable(route = OnBoardingAndHomeScreen.OnBoardingPage.route) {
            OnBoardScreens(navController)
        }
        composable(
            route = OnBoardingAndHomeScreen.HomeScreen.route
        ) {
            HomeScreen()
        }
    }
}