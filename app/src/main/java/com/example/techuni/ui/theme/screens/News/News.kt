package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_ABOUTSCREEN
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.ROUTE_UNIVERSITY_PLAY_POLICY
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun NewsScreen(navController: NavController){
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
        Box(modifier = Modifier.padding(padding)) {

            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
                .verticalScroll(rememberScrollState())

            ) {
                Text(text = "TU-K News ",
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        textAlign = TextAlign.Center, color = Color.Red
                    ), fontSize = 32.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row (
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ){

                    Card(
                        modifier = Modifier
                            .height(320.dp)
                            .width(250.dp)
                    ) {
                        Column(
                            Modifier
                                .background(color = Color.White)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.news),
                                    contentDescription = "newyork",
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "VC Prof. Benedict Mutua (2nd R) among other distinguished guests receive Cabinet Secretary, Ministry of Information, Communication and Digital Economy, Eliud Owalo who was the Chief Guest during 3rd Regional Research " +
                                        "Conference that was held at Kenya School of Government",
                                fontSize = 11.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,

                            )
                            Spacer(modifier = Modifier.width(5.dp))


                        }



                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Card(
                        modifier = Modifier
                            .height(320.dp)
                            .width(250.dp)
                    ) {
                        Column(
                            Modifier
                                .background(color = Color.White)
                        ) {
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(150.dp),
//                                contentAlignment = Alignment.Center
//                            ) {
////                                Image(
////                                    painter = painterResource(id = R.drawable.news1),
////                                    contentDescription = "newyork",
////                                    contentScale = ContentScale.Crop
////                                )
//                            }
                            Text(text = "Universities Play Critical Role in Big Data and Digitization Rollout ",
                                fontSize = 19.sp,
                                color = Color.Blue
                                )
                            Text(
                                text = "Partnership between universities and industry is critical in ensuring uptake of digital-based solutions in the processing of lands records in Kenya.\n\n" +
                                        "The Technical University of Kenya (TU-K) VC Prof. Benedict Mutua, who was speaking during the 3rd Regional Research Conference themed;"
                                 ,
                                fontSize = 11.sp,
                            )

//
//                            Text(
//                                text = "Partnership between universities and industry is critical in ensuring uptake of digital-based solutions in the processing of lands records in Kenya.\n\n" +
//
//                                        "and quality information in land administration that is helpful in both private and public sectors.",
//                                fontSize = 11.sp,
//                            )
                            TextButton(onClick = { navController.navigate(
                                ROUTE_UNIVERSITY_PLAY_POLICY) }) {
                                Text(text = "Read More",
                                   style = TextStyle( textDecoration = TextDecoration.Underline,
                                    textAlign = TextAlign.Center, color = Color.Red
                                ),)
                            }



                        }



                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun NewsScreenPreview(){
    NewsScreen(rememberNavController())
}