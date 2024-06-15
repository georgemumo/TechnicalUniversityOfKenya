package com.apk.george.ui.theme.screens.HOME

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.techuni.navigation.ROUTE_HOME
//import com.example.techuni.navigation.TopApp
import com.example.techuni.navigation.navigation.BottomNavigationBar

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
//        scaffoldState = scaffoldState,
//        topBar = { TopApp() },
        bottomBar = {  BottomNavigationBar(navController = navController)
        },


        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                Icon(imageVector = Icons.Filled.Create, contentDescription = null)
            }
        },


        ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
    Column {
       Text(text = "Welcome to my home page")

    }

}

}
}