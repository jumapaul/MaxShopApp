package com.example.maxshop.routes

sealed class Screens(val route: String){
    object HomeScreen: Screens("home_screen")
    object OnBoardingPage: Screens("onboard_screen")
    object FirstScreen: Screens("first_screen")
    object SecondScreen: Screens("second_screen")
}
