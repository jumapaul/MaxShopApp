package com.example.maxshop.presentation.screens.onboard.viewpage

import android.content.Context
import android.preference.PreferenceManager
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.maxshop.R
import com.example.maxshop.presentation.screens.onboard.viewpage.viewpagerdata.OnBoardingData
import com.example.maxshop.routes.Screens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardScreens(
    navController: NavHostController,
) {
    val onBoardingScreenItem = ArrayList<OnBoardingData>()
    onBoardingScreenItem.add(
        OnBoardingData(
            R.drawable.onboard_1,
            R.string.first_onBoard,
            R.string.first_onBoard_statement
        )
    )

    onBoardingScreenItem.add(
        OnBoardingData(
            R.drawable.onboard_2,
            R.string.second_onBoard,
            R.string.first_onBoard_statement
        )
    )

    onBoardingScreenItem.add(
        OnBoardingData(
            R.drawable.onboard_3,
            R.string.third_onBoard,
            R.string.first_onBoard_statement
        )
    )

    val pagerState = rememberPagerState(
        pageCount = onBoardingScreenItem.size, initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = onBoardingScreenItem, pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.lemon_chiffon)),
        navController
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = item[page].image),
                        contentDescription = "",
                        modifier = Modifier
                            .defaultMinSize(minHeight = 250.dp)
                            .fillMaxWidth()
                            .padding(top = 60.dp)
                    )

                    Text(
                        text = stringResource(id = item[page].title),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp),
                        fontFamily = FontFamily(
                            Font(R.font.nunito_extra_bold_italic)
                        ),
                        fontSize = 30.sp
                    )

                    Text(
                        text = stringResource(id = item[page].description),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        fontFamily = FontFamily(
                            Font(R.font.nunito_medium)
                        )
                    )
                }
            }

            PagerIndicator(item.size, pagerState.currentPage)
        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomSection(
                currentPager = pagerState.currentPage,
                pagerState,
                navController,
                LocalContext.current
            )
        }
    }
}

@Composable
fun PagerIndicator(
    size: Int,
    currentPage: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 40.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 10.dp else 5.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(5.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Color.Blue else Color.LightGray.copy(alpha = 0.5f)
            )
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomSection(
    currentPager: Int, pagerState: PagerState,
    navController: NavController,
    context: Context
) {

    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {

        if (currentPager == 2) {
            OutlinedButton(
                onClick = {
                    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("on_boarding_complete", true)
                    editor.apply()
                    navController.navigate(Screens.HomeScreen.route)

                },
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp)
                )
            }
        } else if (currentPager == 0) {
            NextButton(text = "", modifier = Modifier.padding(start = 20.dp))
            NextButton(text = "Next", modifier = Modifier
                .padding(end = 20.dp)
                .clickable {
                    CoroutineScope(Dispatchers.Main).launch {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                })
        } else {
            NextButton(text = "Back", modifier = Modifier
                .padding(start = 20.dp)
                .clickable {
                    CoroutineScope(Dispatchers.Main).launch {
                        pagerState.scrollToPage(pagerState.currentPage - 1)
                    }
                })
            NextButton(text = "Next", modifier = Modifier
                .padding(end = 20.dp)
                .clickable {
                    CoroutineScope(Dispatchers.Main).launch {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                })
        }
    }
}

@Composable
fun NextButton(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.nunito_regular)),
        modifier = modifier
    )
}

