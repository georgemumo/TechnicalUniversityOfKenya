package com.example.techuni.ui.theme.screens.About

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun AboutTUKScreen(navController: NavController){
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
            Column (
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .background(color = Color.White)
            ){
                Box {
                    Text(text = "\n" +
                            "About the school\n" +
                            "\n" +
                            "The School of Creative Arts and Media forms an integral part of cultural communication and expression. Under this subject area, the School aims to explore creativity from visual, sonic and movement perspectives. The development of thinking, imagination, interpretation, exploration and presentation skills goes a long way in enhancing people’s perceptual, analytical and expressive capacities. These are abilities that serve humanity well in creating aesthetic moments and expressions.  Further, they enable individuals’ function effectively in discerning and generating solutions to societal problems, thereby encouraging interpersonal intercultural and intergenerational relations. In this will be found the subject areas of design, journalism music and performing arts in many formats including, dance, drama, choreography, photography, film and video, music, theatre, graphic, plastic and ephemeral design.\n" +
                            "This School finds a niche at the Technical University of Kenya due to the university’s mandate of training all levels of technical experts for industry. The creative and cultural sectors of industry have a large following in the country, but there is little formal and structured training of personnel for it.  The combination of these disciplines in one house facilitates cross-fertilisation of abilities, concepts and creative processes because, traditionally, the aesthetic and functional expressions in Kenya are multisensory and multimedia.  Teaching and learning will borrow from different disciplines and forms to enrich learners’ experience towards the formation of a holistic creative practitioner. Besides, there is a shared vocabulary of concepts and practices amongst these cultural expressions that demand shared approaches in their teaching. The School is expected to be a thriving hub of creativity, performance, information and product generation.\n" +
                            "The School’s objective is to ensure that learning, within an applied creative framework, results in processes and products that meet the needs of the real world. These processes and products will utilise current trends and projected possibilities within the creative industries, to propel learners to apply skills and creativity in response to demand-driven industry and national needs. In addition, the task of the School will be to ensure the implementation of design paradigm in all its fields, and the shaping of creative, practical and research methods, that are relevant to sustainable Implementation. The intent is to base the paradigms in an overarching consideration of with the concept of Social Design that promotes the wellbeing of individuals and communities in a sustainable way.\n" +
                            "The School of Creative Arts and Media focuses on training individuals who generate products characterised by both originality and appropriateness.  It houses a combined force of creative and visual, technological and innovative disciplines, which provides both academic and professional development.  These disciplines function towards developing a professional workforce that meets national needs while generating a vibrant image for the Technical University of Kenya.\n" +
                            "Directory: Block ‘F’ ground floor room 7\n")
                }
            }


        }
 }


}