package com.example.techuni.ui.theme.screens.HOME

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_ADDEVENTSCREEN
//import com.example.techuni.navigation.ROUTE_NOTICES
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.ROUTE_SAVENOTICE
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun AddScreen(navController: NavController){
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
                Icon(imageVector = Icons.Filled.Create, contentDescription = null)
            }
        },
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerBackgroundColor = colorResource(id = R.color.black),
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        backgroundColor = colorResource(id = R.color.white)
    ) { padding ->  // We need to pass scaffold's inner padding to content. That's why we use Box.
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(padding)) {
            Image(
                painter = painterResource(id = R.drawable.back
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = 10.dp,
                    backgroundColor = Color.Cyan,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                           TextButton(onClick = {navController.navigate(ROUTE_ADDEVENTSCREEN)  }) {
                               Text(text = "Add Event")
                           }
                            Spacer(modifier = Modifier.width(180.dp))
                            IconButton(onClick = {navController.navigate(ROUTE_ADDEVENTSCREEN)}) {
                                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextButton(onClick = {navController.navigate(ROUTE_SAVENOTICE)  }) {
                                Text(text = "Add Notice")
                            }
                            Spacer(modifier = Modifier.width(180.dp))
                            IconButton(onClick = {navController.navigate(ROUTE_SAVENOTICE)}) {
                                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
                            }
                        }


                    }




                    }
                }

        }
        }

}