package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
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
//import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_ABOUTSCREEN
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.ROUTE_UNIVERSITY_PLAY_POLICY
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.techuni.navigation.ROUTE_CONFRENCESCREEN
import com.example.techuni.navigation.ROUTE_PHOTOSTAKEN

//import java.lang.reflect.Modifier


@Composable
fun UniversityPlayScreen(navController: NavController){

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
            Column(
                Modifier
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState())) {
                Image(painter = painterResource(id = R.drawable.news), contentDescription = "")
                Text(
                    text = "Partnership between universities and industry is critical in ensuring uptake of digital-based solutions in the processing of lands records in Kenya."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "The Technical University of Kenya (TU-K) VC Prof. Benedict Mutua, who was speaking during the 3rd Regional Research Conference themed; Data, Innovation and Technology for Land Governance said that the conference is taking place when the university has set up a base for big data research and quality information in land administration that is helpful in both private and public sectors."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "The two-day conference was jointly organised by the National Land Commission, the National Research Fund (NRF), the Ministry of Lands, Public Works and Urban Development, TU-K, University of Nairobi and Food and Agriculture Organization (FAO)."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Prof. Mutua noted that the university is partnering with the Ministry of Lands and state agencies to implement digital solutions, including artificial intelligence."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "“We are creating a huge data-base and now, we want to work with National Land Commission so that we have the technical expertise and also the social expertise. As a university, we are hands-on,” the VC said."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ministry of Information, Communication, and Digital Economy Cabinet Secretary, Eliud Owalo who was the chief guest during the conference, highlighted the critical role universities among other research institutions play in growing the economy through the uptake of new technologies."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "“There is a wide array of opportunities of partnership between the Ministry of Information, Communication and Digital Economy, Ministry of Lands, and the National Land Commission,” he said."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "The CS highlighted that the government will fast-track the adoption of Artificial Intelligence and data in implementing land reforms to safeguard the security of processes, therefore ensuring transparency in the sector and weed-out corrupt practices."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Researchers, policy makers, practitioners, private sector players, civil society, and other stakeholders deliberated on issues including: the nexus between land and climate change, climate-smart land governance and administration: opportunities and challenges, climate change adaptation as well as indigenous and contemporary knowledge management systems."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Other areas of discussion included; gendered approaches towards climate-smart land management and administration, carbon trading in the region and emerging land issues."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Prof. Mutua highlighted that TU-K has launched new PhD, Masters and short courses which are in line with the theme of the conference. The courses include: PhD in Geospatial Sciences and Master of Science in Land Administration. Short courses included; Geospatial data mining in R programming language, Remote sensing image analysis in Google earth engine, Topographic mapping and object extraction from drone captured imagery and Automation of Land Administration processes."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box( contentAlignment = Alignment.BottomStart,
                    modifier = Modifier.fillMaxSize()) {
                    TextButton(onClick = { navController.navigate(ROUTE_PHOTOSTAKEN) }) {
                        Text(text = "Photos Taken",
                            style = TextStyle( textDecoration = TextDecoration.Underline,
                                textAlign = TextAlign.Center, color = Color.Red
                            ),)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "NOTICES  ",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), textDecoration = TextDecoration.Underline, color = Color.Blue
                    )
                }
                Card {
                    Image(painter = painterResource(id = R.drawable.link1), contentDescription = "")
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = " Conference Announcement and Call for Papers \n",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), color = Color.Blue
                    )
                }



            }


        }
        }




}
@Preview
@Composable
fun UniversityScreenPreview(){
    UniversityPlayScreen(rememberNavController())
}