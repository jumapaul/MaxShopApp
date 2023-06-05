package com.example.maxshop.presentation.screens.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maxshop.presentation.screens.homescreen.image_slider.AutoSliding
import com.example.maxshop.presentation.screens.search.SearchScreen
import com.example.maxshop.routes.home_navigation.HomeNavGraph
import com.example.maxshop.routes.home_navigation.HomeRoutes
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun HomeScreen(
) {

    val navHostController = rememberNavController()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 200.dp)
    ) {
        AutoSliding()

//        NavHost(
//            navController = navHostController,
//            startDestination = HomeRoutes.HomeScreen.route
//        ) {
//            composable(HomeRoutes.HomeScreen.route) {
//                HomeScreen()
//            }
//
//            composable(HomeRoutes.SearchScreen.route) {
//                SearchScreen()
//            }
//        }
    }
}