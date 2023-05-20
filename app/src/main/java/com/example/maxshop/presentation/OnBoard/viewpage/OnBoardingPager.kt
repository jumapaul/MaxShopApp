package com.example.maxshop.presentation.OnBoard.viewpage

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.maxshop.R
import com.example.maxshop.presentation.OnBoard.viewpage.viewpagerdata.OnBoardingData
import com.example.maxshop.routes.Screens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
//    navController: NavController
) {
    Box(modifier = modifier) {
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
                currentPager = pagerState.currentPage, //navController = navController
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

@Composable
fun BottomSection(currentPager: Int,
                 // navController: NavController
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
                    //navController.navigate(Screens.HomeScreen.route)
                },
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp)
                )
            }
        } else if (currentPager == 0) {
            SkipNextButton(text = "Next", modifier = Modifier.padding(end = 20.dp))
        } else {
            SkipNextButton(text = "Back", modifier = Modifier.padding(start = 20.dp))
            SkipNextButton(text = "Next", modifier = Modifier.padding(end = 20.dp))
        }
    }
}

@Composable
fun SkipNextButton(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.nunito_regular)),
        modifier = modifier
    )
}