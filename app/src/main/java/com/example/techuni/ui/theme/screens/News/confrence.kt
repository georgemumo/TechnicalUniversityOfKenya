package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.techuni.R
//import java.lang.reflect.Modifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.techuni.Drawer
import com.example.techuni.navigation.ROUTE_ABOUTSCREEN
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun ConfrenceScreen(    navController: NavController){

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
            Column (modifier = Modifier
                .background(color = Color.White)
                .verticalScroll(rememberScrollState())
            ){


                    Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "School of Creative Arts and Media", style = TextStyle(color = Color.Blue), fontSize = 26.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Box {
                        Text(text = "4th International Technical University of Kenya - Exploring Visual Cultures Conference\n" +
                                "\n" +
                                "November 27-29, 2024 | The Edge Convention Centre Nairobi, Kenya")
                    }



                    Box (contentAlignment = Alignment.Center){
                        Text(text = "ABOUT THE SCHOOL",style = TextStyle(color = Color.Blue,textDecoration = TextDecoration.Underline), fontSize = 24.sp)
                    }
                Column {

                        Text(text = "Hands-on design education and training at SCAM is about combining creativity with technology to satisfy needs in" +
                                " rapidly changing economies, diverse modes of production and complex aesthetic demands..>>")
                        Spacer(modifier = Modifier.height(1.dp))
                        TextButton(onClick = {navController.navigate(ROUTE_ABOUTSCREEN) }) {
                            Text(text = "Read About the School", style = TextStyle(textDecoration = TextDecoration.Underline), color = Color.Red)
                        }

                }


                Row (
                    modifier = Modifier.horizontalScroll(rememberScrollState())){

                    Spacer(modifier = Modifier.width(9.dp))



                            Card(){
                                Column {
                                    Text(text = "SCHOOLS IN THE FACULTY OF SOCIAL \n" +
                                            "SCIENCES AND TECHNOLOGY",style = TextStyle(color = Color.Blue,textDecoration = TextDecoration.Underline), fontSize = 20.sp)
                                    TextButton(onClick = { /*TODO*/ }) {
                                        Text(text = "School of Business and Management Studies")
                                    }

                                    TextButton(onClick = { /*TODO*/ }) {
                                        Text(text = "School of Creative Arts and Media")
                                    }

                                    TextButton(onClick = { /*TODO*/ }) {
                                        Text(text = "School of Hospitality and Human Ecology")
                                    }

                                    TextButton(onClick = { /*TODO*/ }) {
                                        Text(text = "School of Information and Communication Studies")
                                    }

                                    TextButton(onClick = { /*TODO*/ }) {
                                        Text(text = "Centre for Science and Technology Studies")
                                    }

                                    TextButton(onClick = { /*TODO*/ }) {
                                        Text(text = "Centre for Language and Communication Studies")
                                    }


                                }


                            }


//                        TextButton(onClick = "")
//                        Text(text = "")
//                        Text(text = "")
//                        Text(text = "")
//                        Text(text = "")
//                        Text(text = "")



                    Spacer(modifier = Modifier.width(9.dp))


                        Card {
                            Column {

                                    Text(text = "COLLABORATORS AND PARTNERS",style = TextStyle(color = Color.Blue, textDecoration = TextDecoration.Underline), fontSize = 20.sp)


                                    Text(text = "Barnard College : Colombia University")
                                    Text(text = "University of Bristol")
                                    Text(text = "National Museums of Kenya")
                                    Text(text = "Machakos County Government")
                                    Text(text = "The Birmingham City University")

                            }

                        }

                }

            }


        }
    }


}