package com.example.maxshop.routes.home_navigation

import java.util.Objects

sealed class HomeRoutes(
    val route: String
) {
    object HomeScreen : HomeRoutes("Home")
    object SearchScreen : HomeRoutes("Search")
}
