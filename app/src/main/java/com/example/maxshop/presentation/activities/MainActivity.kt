package com.example.maxshop.presentation.activities

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.maxshop.presentation.screens.main_screen.MainScreen
import com.example.maxshop.routes.NavGraph
import com.example.maxshop.routes.Screens
import com.example.maxshop.theme.MaxShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val onBoardingShown = sharedPreferences.getBoolean("on_boarding_complete", true)
        setContent {
            MaxShopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavGraph(navController = navController)

                    if (onBoardingShown){
                        navController.navigate(Screens.HomeScreen.route){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }else{
                        Screens.OnBoardingPage.route
                    }

                    MainScreen()
                }
            }
        }
    }
}