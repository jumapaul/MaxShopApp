package com.example.maxshop.presentation.OnBoard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maxshop.R
import com.example.maxshop.presentation.HomeScreen
import com.example.maxshop.presentation.OnBoard.viewpage.OnBoardingPager
import com.example.maxshop.presentation.OnBoard.viewpage.viewpagerdata.OnBoardingData
import com.example.maxshop.routes.Screens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainFunction(
) {
    val onBoardingScreenItem = ArrayList<OnBoardingData>()


    onBoardingScreenItem.add(
        OnBoardingData(
            R.drawable.splash1,
            R.string.first_onBoard,
            R.string.first_onBoard_statement
        )
    )

    onBoardingScreenItem.add(
        OnBoardingData(
            R.drawable.splash2,
            R.string.second_onBoard,
            R.string.first_onBoard_statement
        )
    )

    onBoardingScreenItem.add(
        OnBoardingData(
            R.drawable.splash3,
            R.string.third_onBoard,
            R.string.first_onBoard_statement
        )
    )

    val pagerState = rememberPagerState(
        pageCount = onBoardingScreenItem.size, initialOffscreenLimit = 2,
        infiniteLoop = false, initialPage = 0
    )


    OnBoardingPager(
        item = onBoardingScreenItem, pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.lemon_chiffon))
    )

}