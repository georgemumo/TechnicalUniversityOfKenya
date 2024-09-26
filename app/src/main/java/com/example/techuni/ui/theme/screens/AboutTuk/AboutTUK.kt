package com.example.techuni.ui.theme.screens.AboutTuk

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar
import com.example.we_can.screens.actions.Topic

//import com.example.we_can.navigation.BottomNavigationBar

@Composable
fun AboutTUK(topic: List<Topic>, navController: NavController) {
    val scope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerBackgroundColor = colorResource(id = R.color.black),
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        backgroundColor = colorResource(id = R.color.white)
    ) {
        Box {
            Image(painter = painterResource(id = R.drawable.back), contentDescription = "",Modifier.size(800.dp))
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it)
                    .verticalScroll(rememberScrollState())
            ){
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(top = 36.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "About Technical University Of Kenya", color = Color.Black, style = TextStyle(textDecoration = TextDecoration.Underline), fontSize = 23.sp)
                }
                topic.forEach { topic ->
                    AccordionItem(topic = topic, navController)
                }
            }
        }


    }
}
