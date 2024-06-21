package com.example.techuni.ui.theme.screens.HOME

import android.text.SpannableString
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
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techuni.Drawer
import com.example.techuni.R
//import com.example.techuni.navigation.TopApp
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.techuni.navigation.ROUTE_ABOUTSCREEN
import com.example.techuni.navigation.ROUTE_ACCORDION_ITEM
import com.example.techuni.navigation.ROUTE_HOME
import com.example.techuni.navigation.ROUTE_MUTUAS
import com.example.techuni.navigation.ROUTE_REGISTER
//import com.example.techuni.navigation.ROUTE_STUDENTCOUNCIL
import com.example.techuni.navigation.ROUTE_UNIVERSITYCOUNCIL

//import com.example.we_can.navigation.ROUTE_POST

@Composable
fun HomeScreen(navController: NavController){
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

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())

        ) {
        Box {
            Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
        }
        Text("Welcome to the Technical University of Kenya (TU-K)!\n", color = Color.Blue,
            fontSize = 24.sp)
        val text = SpannableString("Vision - To be a top rated University of technology\n")


        val annotatedText = buildAnnotatedString {
            withStyle( style =SpanStyle(fontWeight = FontWeight.Bold)){
                append("Vision-")
            }

                append("To be a top rated University of technology\n")

        }

        Text(text = annotatedText)
        val anot = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append("Mission- ")
            }
                append("To provide technological education and training\n" +
                    "and to contribute towards the advancement of society\n" +
                            "through research and innovation\n")
        }


        Text(text = anot)
        val gh = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append("Moto- ")
            }
            append(" Education and training for the real world")
        }
        Text(text = gh)
        Row (
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ){

            Card(
                modifier = Modifier
                    .height(450.dp)
                    .width(250.dp)
            ) {
                Column(Modifier.background(color = Color.Blue)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.home1),
                            contentDescription = "newyork",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "About T-UK",
                        fontSize = 25.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "The Technical University of Kenya shares history with the development\n" +
                                "of the first three higher education institutions in East Africa.\n" +
                                "In the 1920s there were heightened agitations for the expansion of access to higher education by indigenous leaders in the East \n" +

                                "African ...",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),

                    )
                    TextButton(onClick = {navController.navigate(ROUTE_ACCORDION_ITEM) }) {
                        Text(text = "Read more about TU-K", fontSize = 15.sp,
                            style = TextStyle(
                                textDecoration = TextDecoration.Underline,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.fillMaxWidth())
                    }


                }
            }
            Spacer(modifier = Modifier.width(5.dp))


            Card(
                modifier = Modifier
                    .height(450.dp)
                    .background(color = Color.White)
                    .width(300.dp)

            ) {
                Column (Modifier.background(color = Color.Blue)){
                    Text(text = "The University Council ", color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 23.sp
                        )
                    Text(
                        text = "The Council is the supreme governing body of the institution.\n" +
                                "Its principal mandate is to oversee the activities and operations\n" +
                                "of the institution on behalf of the Government. In this, the\n" +
                                "Council is concerned with the setting of broad policy directions\n" +
                                "for the institution and to follow up on how such policies are\n" +
                                "being executed by management. As the reporting agency to\n" +
                                "Government, the Council is responsible for the approval of the  \n" +
                                " budget and the performance contract. The Council is also considered " ,


                        fontSize = 15.sp,


                        )
                    TextButton(onClick = {navController.navigate(ROUTE_UNIVERSITYCOUNCIL) }) {
                        Text(text = " >> University Council",
                            fontSize = 15.sp,
                            style = TextStyle(
                                textDecoration = TextDecoration.Underline,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.fillMaxWidth()
                            )
                    }

                }





            }
            Spacer(modifier = Modifier.width(5.dp))




            Card(
                modifier = Modifier
                    .height(450.dp)
                    .width(250.dp)
            ) {
                Column (Modifier.background(color = Color.Blue)){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profmutua),
                            contentDescription = "newyork",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Prof. Dr.-Ing. Benedict M. Mutua, is a Professor of Water Resources,\n" +
                                "Environmental and Hydraulics Engineering. Over the years, he has\n" +
                                "served in various capacities at the University setting at the\n" +
                                "internationalHe is a Professor in several reputable universities. Prof. Mutua obtained his " +
                                "BSc Agricultural Engineering  ...",
                        fontSize = 15.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    TextButton(onClick = {navController.navigate(ROUTE_MUTUAS) }) {
                        Text(text = ">> Prof Mutuas Profile ",
                            fontSize = 15.sp,
                            style = TextStyle(
                                textDecoration = TextDecoration.Underline,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.fillMaxWidth()
                            )
                    }

                }
            }




        }

    }
            //            androidx.navigation.Navigation(navController = navController)
        }
    }

}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
}