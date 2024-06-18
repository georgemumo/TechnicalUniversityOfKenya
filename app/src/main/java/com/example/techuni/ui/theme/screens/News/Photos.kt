package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar


@Composable
fun PhotosTaken(navController: NavController){

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
                .verticalScroll(rememberScrollState()),

                ){

                Box(
                    contentAlignment = Alignment.TopStart,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Wednesday, 12 June 2024  ",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 11.sp), color = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Universities Play Critical Role in Big Data and Digitization Rollout ",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), color = Color.Blue
                    )
                }

                Image(painter = painterResource(id = R.drawable.news5), contentDescription ="" , modifier = Modifier
                    .size(250.dp)
                    .width(400.dp))

                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    Card(modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)) {
                        Image(painter = painterResource(id = R.drawable.news3 ), contentDescription = "")
                    }

                    Spacer(modifier = Modifier.width(5.dp))
                    Card (modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)){
                        Image(painter = painterResource(id = R.drawable.news) , contentDescription ="" )
                    }

                }

                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    Card(modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)) {
                        Image(painter = painterResource(id = R.drawable.news6 ), contentDescription = "")
                    }

                    Spacer(modifier = Modifier.width(5.dp))
                    Card (modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)){
                        Image(painter = painterResource(id = R.drawable.news7) , contentDescription ="" )
                    }

                }

                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    Card(modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)) {
                        Image(painter = painterResource(id = R.drawable.news9 ), contentDescription = "")
                    }

                    Spacer(modifier = Modifier.width(5.dp))
                    Card (modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)){
                        Image(painter = painterResource(id = R.drawable.news8) , contentDescription ="" )
                    }

                }
                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    Card(modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)) {
                        Image(painter = painterResource(id = R.drawable.news10 ), contentDescription = "")
                    }

                    Spacer(modifier = Modifier.width(5.dp))
                    Card (modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)){
                        Image(painter = painterResource(id = R.drawable.news11) , contentDescription ="" )
                    }

                }
                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    Card(modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)) {
                        Image(painter = painterResource(id = R.drawable.news12 ), contentDescription = "")
                    }

                    Spacer(modifier = Modifier.width(5.dp))
                    Card (modifier = Modifier
                        .height(130.dp)
                        .width(200.dp)){
                        Image(painter = painterResource(id = R.drawable.news13) , contentDescription ="" )
                    }

                }


            }

        }
        }


}
@Preview
@Composable
fun PhotosTkenScreenPreview(){
    PhotosTaken(rememberNavController())
}