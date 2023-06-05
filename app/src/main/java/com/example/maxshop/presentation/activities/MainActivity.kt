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
import com.example.maxshop.presentation.screens.main_screen.MainScreenView
import com.example.maxshop.routes.onboarding_navigation.OnBoardHomeNavGraph
import com.example.maxshop.routes.OnBoardingAndHomeScreen
import com.example.maxshop.routes.home_navigation.HomeNavGraph
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

                    OnBoardHomeNavGraph(navController = navController)

                    if (onBoardingShown){
                        navController.navigate(OnBoardingAndHomeScreen.HomeScreen.route){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }else{
                        OnBoardingAndHomeScreen.OnBoardingPage.route
                    }

                    MainScreenView()
                }
            }
        }
    }
}