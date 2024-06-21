package com.example.techuni.ui.theme.screens.News.news

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_PHOTOSTAKENONAWARDCOLLABORATION
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.ROUTE_TRANSVIEWPHOTOS
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun TransNewsScreen(navController: NavController){
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
                .background(color = Color.White)
                .verticalScroll(rememberScrollState())
            ) {
                val textContent = """
        The Technical University of Kenya recently has signed an MoU with Transilvania University of Brașov, Romania. The signing ceremony took place at the Romanian Embassy in Nairobi. TU-K Vice-Chancellor Prof. Benedict Mutua and Transilvania University of Brașov Dean, Faculty of Furniture Design and Wood Engineering Prof. Alin OLĂRESCU signed the MoU on behalf of their respective institutions.
        
        Present during the event were the Romanian Ambassador to Kenya, H.E Gentiana Serbu, and TU-K Deputy Vice-Chancellor in-charge of Institutional Advancement and Enterprises (IAE) Prof. Paul Wambua, among other dignitaries.
        
        TU-K enjoys mutual relationship with the Embassy of Romania. The two have jointly taken part in various activities among them; ‘The Romanian International Day for Cultural Diversity and Development, held in Nairobi from 21st May.’ The event exhibited cultural heritage and traditions from Kenya and Romania. Music, dance and art defined the occasion.
        
        The recent visit by Romanian President, Klaus Iohannis to Kenya, has strengthened relations between the two countries. “The recent visit by our President to Kenya was a clear demonstration that the two countries are committed to strengthening their relations and cooperation in various areas of development for the mutual benefit of their people," said Amb. Serbu.
        
        She added that her country had played a pivotal role in awarding scholarships to Africa and that Kenya will enjoy excellent and stable corporation, friendship and partnership.
        
        The MoU will cover academic, exchange programmes for lecturers and students, conferences, workshops, music, dance, art and theatre.
    """
                Text(
                    text = textContent,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextButton(onClick = {navController.navigate(ROUTE_TRANSVIEWPHOTOS) }) {
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