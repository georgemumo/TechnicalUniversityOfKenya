package com.example.techuni.ui.theme.screens.News.news
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.techuni.Drawer
//import com.example.techuni.R
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar
import com.example.we_can.screens.actions.News

//import com.example.we_can.navigation.BottomNaviga
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_ABOUTSCREEN
import com.example.techuni.navigation.ROUTE_PHOTOSTAKENONAWARDCOLLABORATION
import com.example.techuni.navigation.ROUTE_REGISTER

@Composable
fun AwardCollaboration(navController: NavController){
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

            val headerText = "Sixty eight students from the Technical University of Kenya have been awarded the prestigious Global Collaboration certificate by X-Culture, a renowned business coaching organisation."
            val awardDetailsText = "The certificates were presented by Elizabeth Rose, a Research Chair Professor at X-Culture. The students had been trained for seven weeks. The training places students in top cadre in their careers; either in employment, business or in entrepreneurship."
            val trainingText = "Prof. Rose who gave a lecture during the award ceremony at TU-K, said students or career persons acquire critical skills and unique experience that employers value in today’s business world."
            val lectureText = "The Acting DVC – Academic, Research and Students, Prof. Francis Gatheri Ag. Dean, Faculty of Social Sciences and Technology, Prof. Tom Kwanya, DBAE Academic Team Leader, Prof. Vidijah Sagwa, together with ATL, Modern and Classical Languages Dr. Teresa Atieno Otieno attended the award ceremony."
            val coordinatorText = "Dr. Lilian Ogendo, Senior Lecturer, in the Department of Business Administration and Entrepreneurship (DBAE) is the lead coordinator for X-culture in Kenya."
            val previousAwardsText = "Earlier, 60 students largely drawn from the School of Business underwent a training and were awarded certificates. The students are part of the more than 6,400 students from 140 universities in 40 countries that X-Culture has a representation in training and coaching in international business and learning by doing."
            val learningAreasText = "The main areas of learning is geared towards improving cultural intelligence, international and virtual collaboration competencies, problem-solving skills, and interest in cross-cultural interactions.\n\nOther areas include; research and publishing, improving teaching and evaluation as well as expanding professional network."
            val scholarshipText = "The students are beneficiaries of a scholarship through funding by Prof. Vas Taras, who is the X-culture founder. The entire training fee and facilitation is 1,000 USD for each student."

            Column (modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(color = Color.White)){
                Box {
                    Image(painter = painterResource(id = R.drawable.st) , contentDescription = null)
                }
                Text(
                    text = headerText,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = awardDetailsText,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = trainingText,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = lectureText,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = coordinatorText,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = previousAwardsText,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = learningAreasText,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = scholarshipText,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier.height(5.dp))
                TextButton(onClick = {navController.navigate(ROUTE_PHOTOSTAKENONAWARDCOLLABORATION) }) {
                    androidx.compose.material3.Text(
                        text = "Photos Taken", fontSize = 15.sp,
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Center
                            , fontWeight = FontWeight.ExtraBold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }
        }
        }



}