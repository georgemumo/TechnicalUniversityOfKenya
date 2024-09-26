package com.example.myapplication.ui.theme.HJ

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.ROUTE_VIEWSTUDENTSCREEN
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun MainScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(ROUTE_REGISTER) }) {
                Icon(imageVector = Icons.Filled.Call, contentDescription = null)
            }
        },
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerBackgroundColor = colorResource(id = R.color.black),
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        backgroundColor = colorResource(id = R.color.white)
    ) { padding ->  // We need to pass scaffold's inner padding to content. That's why we use Box.
        Box(modifier = Modifier.padding(padding)) {
            val rowsData = listOf(
                "Faculty of Engineering and the Built Environment (FEBE)" to listOf(
                    " School of Electrical and Electronic Engineering " to ROUTE_VIEWSTUDENTSCREEN,
                    "School of Architecture and Spatial Planning " to  ROUTE_VIEWSTUDENTSCREEN
                ),
                "Faculty of Social Sciences and Technology (FSST)" to listOf(
                    "School of Business and Management Studies" to  ROUTE_VIEWSTUDENTSCREEN,
                    "School of Creative Arts and Media" to  ROUTE_VIEWSTUDENTSCREEN
                )
            )

            Column {
                rowsData.forEach { (title, buttons) ->
                    ExpandableRow(title = title, buttons = buttons, navController = navController)
                }
            }

            }
        }

}
