package com.example.techuni.ui.theme.screens.HOME

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun UniversityCouncil(navController: NavController){
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
            Column(

                modifier = Modifier
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState())
            ) {
                Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Text(text = "The University Council", color = Color.Blue, fontSize = 21.sp, fontWeight = FontWeight.ExtraBold )

                }
                Text(text =  "The Council is the supreme governing body of the institution. Its principal mandate is to oversee the activities and operations of the institution on behalf of the Government. In this, the Council is concerned with the setting of broad policy directions for the institution and to follow up on how such policies are being executed by management. As the reporting agency to Government, the Council is responsible for the approval of the budget and the performance contract. The Council is also considered as the employer on behalf of the Government and the management thus only employs staff on behalf of the Council. The Council is responsible for ensuring that there are adequate structures in place for the efficient and effective management of the institution. The composition of the Council shall be as provided for in the Universities Act, 2012.")
                Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Text(text = "Members of the council", color = Color.Blue, fontSize = 21.sp, fontWeight = FontWeight.ExtraBold )
                    Image(painter = painterResource(id = R.drawable.councilpic), contentDescription = null)

                }
            }

        }
        }

}