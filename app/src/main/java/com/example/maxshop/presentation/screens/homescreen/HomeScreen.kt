package com.example.maxshop.presentation.screens.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.maxshop.presentation.screens.homescreen.image_slider.AutoSliding
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun HomeScreen(
) {
    Box(modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = 200.dp)) {
        AutoSliding()
    }
}