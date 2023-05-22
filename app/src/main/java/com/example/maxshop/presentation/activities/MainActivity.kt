package com.example.maxshop.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.maxshop.routes.NavGraph
import com.example.maxshop.theme.MaxShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaxShopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavGraph(navController = navController)


//                    MainFunction(onGetStartedClicked = {onGetStartedClicked()})
//                    val onBoardingCompleted = OnBoardingManager.isOnBoardingCompleted(this)
//
//                    if (!onBoardingCompleted) {
//                        startActivity(Intent(this, MainActivity::class.java))
//                    } else {
//                        startActivity(Intent(this, HomeActivity::class.java))
//                    }
//
//                    finish()
                }

            }
        }
    }

//    private fun onGetStartedClicked(){
//        OnBoardingManager.setOnBoardingCompleted(this)
//
//        startActivity(Intent(this, HomeActivity::class.java))
//
//        finish()
//    }
}