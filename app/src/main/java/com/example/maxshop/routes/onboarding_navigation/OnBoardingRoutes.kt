package com.example.maxshop.routes

sealed class OnBoardingAndHomeScreen(val route: String){
    object HomeScreen: OnBoardingAndHomeScreen("home_screen")
    object OnBoardingPage: OnBoardingAndHomeScreen("onboard_screen")
}
