package com.example.maxshop.presentation.screens.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.maxshop.routes.bottom_navigation.BottomNavigationGraph
import com.example.maxshop.routes.bottom_navigation.BottomNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigator(navController = navController) },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        BottomNavigationGraph(
            navHostController = navController,
            modifier = Modifier
                .padding(padding)
                .background(color = Color.Blue)
        )
    }
}