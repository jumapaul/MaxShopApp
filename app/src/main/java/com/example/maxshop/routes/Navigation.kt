package com.example.maxshop.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maxshop.presentation.HomeScreen
import com.example.maxshop.presentation.OnBoard.MainFunction

@Composable
fun NavGraph() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.OnBoardingPage.route,
    ) {

        composable(route = Screens.FirstScreen.route){

        }
        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(navController = navController)
        }

//        composable(route = Screens.HomeScreen.route){
//            HomeScreen(navController = navController)
//        }


//        composable(
//            route = Screens.OnBoardingPage.route
//        ){
//           // MainFunction(navController)
//        }
    }
}