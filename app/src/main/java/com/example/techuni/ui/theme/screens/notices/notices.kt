package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
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
fun NoticesScreen(navController: NavController){


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
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.back), contentDescription ="" , modifier = Modifier.fillMaxSize())
            Column (modifier = Modifier
                .background(color = Color.White)  ){

              Box(contentAlignment = Alignment.Center) {
                  Text(text = "Notices", color = Color.Blue, fontSize = 24.sp, style = TextStyle(textDecoration = TextDecoration.Underline))
              }
                Spacer(modifier = Modifier.height(10.dp))
                Box(  modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center) {
                    val happy= "Happy Eid-al-Adha"
                    Text(text = happy)
                }
                Spacer(modifier = Modifier.height(10.dp))

                Image(painter = painterResource(id = R.drawable.link1), contentDescription = "")

                Box(  modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center) {
                    val announcement= "Conference Announcement and Call for Papers "
                    Text(text =announcement)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Image(painter = painterResource(id = R.drawable.link2), contentDescription ="" )
                Text(text = "The Technical University of Kenya in partnership " +
                        "with Exploring Visual Cultures will be hosting the 4th International Conference from November 27th to 29th, 2024 at the Edge Convention Centre, Nairobi. The theme of the conference is AI Media Innovations, Applications, Visual Culture, Challenges, and Future Trends. The call for papers is out and the deadline for submission of abstracts is on 31st May, 2024")
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "More on the conference")
                }
            }
        }

        }


}

@Preview
@Composable
fun NoticesScreenPReview(){
    NoticesScreen(rememberNavController())
}