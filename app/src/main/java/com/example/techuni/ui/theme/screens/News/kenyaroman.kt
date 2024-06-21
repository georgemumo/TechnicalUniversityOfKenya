package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_KENYAROMPHOTOS
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

@Composable
fun KenyaRomScreen(navController: NavController){
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

            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState())
            ) {

                val text = """
        Students from the Technical University of Kenya (TU-K) and Universities from Romania participated in a conference and workshop discussions to commemorate the “World Day for Cultural Diversity for Dialogue and Development”./n+
        The cultural exchange is mainly to strengthen multiculturalism and promote the rich traditions of masks across different cultures, with an aim to promote peace and tolerance./n+/n+
        The event was jointly organised by TU-K and Romania Embassy in Kenya. The activities for the day included music, theatre, and traditional dances with masks. These series of activities would mark friendship and partnership between Romania and Kenya./n+/n+
        Distinguished guests who graced the occasion, included Romania Ambassador to Kenya H.E. Mrs. Gentiana Serbu, Serbia Ambassador to Kenya H.E. Ms. Danijela Cubrilo Martic, the VC, Prof, Benedict Mutua, DVC in charge of Institutional Advancement and Enterprises Prof. Paul Wambua, DVC in charge of Research and Technology Advancement Prof. Alfred Orina, Ag. DVC in charge of Students Academics and Affairs Prof. Francis Gatheri./n+/n+
        Presentations with cultural significance and historical contexts made included, “Ritual masks from Serbia former and living tradition” by Mr. Natasa Mladenovic Ribic, the Curator, Centre for the Intangible Cultural Heritage at Ethnographic Museum, Serbia. “Romanian Masks- ancient traditions” by Mr. Virgil Nitulescu, Manager of National Museum of the Romanian Peasant. “Community engagement in developing Kenyan Culture” by Dr. Lydia Muthuma, Senior Lecture, Visual Arts and Photography, TU-K and Mr. Ovidiu Baron, the Deputy Manager of Astra Museum./n+/n+
        In his remarks, the VC, Prof Benedict Mutua welcomed the guests and commended the team that organised the event. Prof. Mutua acknowledged the importance of the event usually commemorated annually on 21st May./n+/n+
        “It is indeed a very important day because it reminds us of the importance of our different cultures, every year the world heritage looks at themes that brings us close to various cultures to discover and experience diversity,” he continued./n+/n+
        H.E. Mrs. Gentiana Serbu, acknowledged the historical significance of the day and gave a brief history of Romania during communist time, how tens of thousands of students from Africa would go there for studies.
    """.trimIndent()
                val additionalText = """
        She noted the National Council for Security has adopted a strategy that Romania now uses, which entails the three most important pillars including security, education and development./n+
        /n+
        “Education is an integral part of what we are doing here today, because once we sign the agreement, the benefits that come along are exchanges of students and professors who get to experience the European programs,” H.E. Mrs. Serbu said./n+
        /n+
        H.E. Ms. Danijela Cubrilo Martic pointed out that the World Day for cultural diversity was established by UNESCO General Conference to encourage greater solidarity in unity of humanity, improve cultural exchange, and thereby contribute to prosperity./n+
        /n+
        “Why does Cultural diversity matter?  That’s a question we can raise on this day, all cultures and civilizations contribute to the wealth of humanity, at the same time 3/4 of the world’s major conflicts have a tradition. Therefore, breeding between cultures is necessary for peace, reservation, stability, and development,” H.E. Ms. Danijela explained.
    """.trimIndent()


                Image(painter = painterResource(id = R.drawable.kenyaroman), contentDescription = null)
                Spacer(modifier = Modifier.height(3.dp))
                text.split("/n+").forEach { line ->
                    Text(text = line.trim())
                }
                Image(painter = painterResource(id =  R.drawable.mask), contentDescription = "")
                Spacer(modifier = Modifier.height(5.dp))
                additionalText.split("/n+").forEach {line ->
                    Text(text = line.trim())

                }
                Spacer(modifier = Modifier.height(3.dp))
                Image(painter = painterResource(id = R.drawable.kenyarom1), contentDescription = null)
                Text(text = "She expressed her joy in seeing many young people sharing the opportunity for intercultural exchange, and willing to learn from each other, noting that she looks forward to receiving more humanitarians to live and work in Serbia.")
                TextButton(onClick = { navController.navigate(ROUTE_KENYAROMPHOTOS) }) {
                    Text(text = "Event Photos", color = Color.Red, style = TextStyle(textDecoration = TextDecoration.Underline))
                }



            }
        }
        }


}
