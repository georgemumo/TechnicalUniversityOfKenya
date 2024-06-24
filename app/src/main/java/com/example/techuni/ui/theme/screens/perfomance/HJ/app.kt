package com.example.myapplication.ui.theme.HJ

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

//import ImageCarousel
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavGraph(startDestination: String = "mainScreen") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("mainScreen") {
            MainScreen(navController)
        }
        composable("screen1") {
            Screen1()
        }
        composable("screen2") {
            Screen2()
        }
        composable("screen3") {
            Screen3()
        }
        composable("screen4") {
            Screen4()
        }
    }
}

@Composable
fun Screen1() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text("Screen 1")
    }
}

@Composable
fun Screen2() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text("Screen 2")
    }
}

@Composable
fun Screen3() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text("Screen 3")
    }
}

@Composable
fun Screen4() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text("Screen 4")
    }
}
