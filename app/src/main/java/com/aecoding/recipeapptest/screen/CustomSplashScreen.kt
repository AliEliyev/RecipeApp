package com.aecoding.recipeapptest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aecoding.recipeapptest.R


@Composable
fun CustomSplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.splash_screen_background),
            contentDescription = "Splash background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.splashBlack))
                .alpha(0f)
        )

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(
                    color = colorResource(R.color.splashIconBackground),
                    shape = RoundedCornerShape(200.dp)
                )
                .align(Alignment.Center)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                painter = painterResource(R.drawable.app_logo),
                contentDescription = ""
            )
        }

    }
}