package com.example.maxshop.routes.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigator(navController: NavController){
    val items = listOf(
        BottomNavRoutes.Home,
        BottomNavRoutes.Category,
        BottomNavRoutes.Favorite,
        BottomNavRoutes.Cart,
        BottomNavRoutes.Account
    )
    
    BottomNavigation(
        backgroundColor = Color.White
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { items ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = items.icon), contentDescription = items.title )},
                label = { Text(text = items.title)},
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = false,
                selected = currentRoute == items.route,
                onClick = {
                    navController.navigate(items.route){
                        navController.graph.startDestinationRoute?.let { route->
                            popUpTo(route){
                                saveState = true
                            }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }

                }
            )
        }
        
    }
}