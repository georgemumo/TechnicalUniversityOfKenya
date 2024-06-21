package com.example.techuni.ui.theme.screens.people

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun MutuasProfileScreen(navController: NavController){
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
            Column (
                modifier = Modifier
                    .background(color = Color.White)
                    .verticalScroll(
                        rememberScrollState()
                    )
            ){
                Box (
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ){
                    Text(text = "The Vice Chancellor", color = Color.Blue, fontSize = 21.sp)

                }
                Spacer(modifier = Modifier.height(3.dp))
                Image(painter = painterResource(id = R.drawable.profmutua), contentDescription =null )
                Text(text = "Prof. Dr.-Ing. Benedict M. Mutua, is a Professor of Water Resources, Environmental and Hydraulics Engineering. Over the years, he has served in various capacities at the University setting at the international level. \n" +
                        "\n" +
                        "He is a Professor in several reputable universities. Prof. Mutua obtained his BSc Agricultural Engineering (Soil and Water Engineering) and graduated with a First Class Honours. He also did a Diploma in Soil and Water Engineering and Obtained a Distinction at Egerton University. He proceeded to the University of Melbourne, Australia, for his MEng. Science in Civil and Environmental Engineering and specialised in Fluid Dynamics and Hydraulics Engineering.\n" +
                        "\n" +
                        "Prof. Mutua pursued a Postgraduate Diploma in Water Resources and Hydrology at Tel Aviv in Israel and later on proceeded to the Hebrew University of Jerusalem, and pursued another MSc degree in Water Resources Engineering (Specialising in Water Engineering Systems and Management. Prof. Mutua did his PhD and post-doctoral in Water Resources and Environmental Engineering at the University of Natural Resources and Life Sciences (BOKU) – Austria.\n" +
                        "\n" +
                        "So far, Prof. Mutua has done five post-doctoral research at different Universities across the world. To enhance his management and administrative skills, Prof. Dr.-Ing. Benedict Mutua did his third Master’s in Business Management (MBA) specialising in Human Resource Management from the Indian Institute of Business Management and Studies (IIBMS).\n" +
                        "\n" +
                        "Prof. Mutua further did another Doctorate in Management Studies (DMS) specialising in Human Resource Management from the Technical University of Berlin, Germany. Prof. Mutua is well versed in research and he has won very many competitive research grants. He has attracted over KES15 billion in his research career. He has contributed and impacted the community positively from his research, innovation and consultancy work in the area of Water Resources and Environmental Engineering. For instance, he designed and developed a simplified tool for Integrated Water and Sanitation Systems to be used by engineers and planners for different water and sanitation systems in towns and cities.\n" +
                        "\n" +
                        "Prof. Mutua has won International Recognition which includes; Marquis Who-is-Who in the World for his research contribution in the Field of Engineering and Science. Prior to joining The Technical University of Kenya (TU-K), Prof. Dr.-Ing. Benedict M. Mutua had held several administrative and leadership positions in the University setting. For instance, he served as a Deputy Vice-Chancellor in charge of Planning, Partnerships, Research and Innovation for close to 8 years and acted as Vice-Chancellor at Kibabii University.\n" +
                        "\n" +
                        "Earlier on, he served as a Director of the School of Graduate Studies at Egerton University, Dean Faculty of Engineering and Technology and Chairperson, Department of Agricultural Engineering at Egerton University and later served as a Member of Council at the then Laikipia University College.\n" +
                        "\n" +
                        "Prof. Mutua has supervised many postgraduate students at Master’s, PhD and Post-doctoral levels and externally examined many Theses. He has been a thematic leader in designing and developing curricula for different Universities. He has published several University-level books and book chapters, scientific articles in peer refereed international journals, peer-reviewed conference proceedings, peer-reviewed technical reports, a number of consultancies and project reports, and refereed learning modules. He is widely travelled and presented his research findings at several national, regional and international conferences and fora. He has over the years won a number of short-term visiting Professorial fellowships tenable in different countries.\n" +
                        "\n" +
                        "Throughout his career, Prof. Dr.-Ing. Benedict M. Mutua has exemplified an unwavering commitment to the values that define a well-functioning University - integrity, innovation, inclusivity, mentorship and a steadfast commitment to nurturing an environment that fosters learning and discovery.\n" +
                        "\n" +
                        "Prof. Dr.-Ing. Benedict M. Mutua possesses the rare ability to inspire, mentor, motivate, and lead by example, fostering a culture of integrity, mentorship, collaboration and innovation that will propel TU-K into a future brimming with possibilities.",)


            }
            }
        }

}