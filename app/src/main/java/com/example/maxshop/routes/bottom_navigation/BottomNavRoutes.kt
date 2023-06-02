package com.example.maxshop.routes.bottom_navigation

import com.example.maxshop.R

sealed class BottomNavRoutes(val title: String, var icon: Int, val route: String){

    object Home: BottomNavRoutes("Home", R.drawable.baseline_home_24, "home")
    object Category: BottomNavRoutes("category", R.drawable.baseline_dashboard_24, "category")
    object Favorite: BottomNavRoutes("Favorite", R.drawable.baseline_favorite_24, "favorite")
    object Cart: BottomNavRoutes("Cart", R.drawable.baseline_shopping_cart_24, "cart")
    object Account: BottomNavRoutes("Account", R.drawable.baseline_account_24, "account")


}
