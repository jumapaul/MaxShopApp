package com.example.maxshop.routes.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.maxshop.presentation.screens.homescreen.HomeScreen
import com.example.maxshop.presentation.screens.account.AccountScreen
import com.example.maxshop.presentation.screens.cart.CartScreen
import com.example.maxshop.presentation.screens.categories.CategoryScreen
import com.example.maxshop.presentation.screens.favorites.FavoritesScreen

@Composable
fun BottomNavigationGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(navController = navHostController, startDestination = BottomNavRoutes.Home.route) {
        composable(BottomNavRoutes.Home.route) {
            HomeScreen()
        }
        composable(BottomNavRoutes.Category.route) {
            CategoryScreen()
        }

        composable(BottomNavRoutes.Favorite.route) {
            FavoritesScreen()
        }

        composable(BottomNavRoutes.Cart.route) {
            CartScreen()
        }

        composable(BottomNavRoutes.Account.route) {
            AccountScreen()
        }
    }
}