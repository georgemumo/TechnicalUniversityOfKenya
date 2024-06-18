package com.example.we_can

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.we_can.R
import com.example.we_can.navigation.ROUTE_REGISTER
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val xOffset = remember { Animatable(-1f) } // Start from off-screen to the left

    LaunchedEffect(key1 = true) {
        // Slide in animation
        xOffset.animateTo(0f, animationSpec = tween(durationMillis = 1000))
        // Delay for some seconds before sliding out
        delay(2000)
        // Slide out animation
        xOffset.animateTo(1f, animationSpec = tween(durationMillis = 1000))
        // Navigate to next screen
        navController.navigate(ROUTE_REGISTER) {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.applogo),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp) // Adjust size as needed
                .offset(x = xOffset.value * 200.dp) // Slide horizontally
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}
