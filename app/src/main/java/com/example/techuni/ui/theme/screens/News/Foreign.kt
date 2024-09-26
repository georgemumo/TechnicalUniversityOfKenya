package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.techuni.R

@Composable
fun ForeignScholars(navController: NavController){
Column(
    modifier = Modifier
        .background(color = Color.White)
        .verticalScroll(rememberScrollState())
        ) {
            Box (modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Magenta), contentAlignment = Alignment.Center){
                Text(text = "Foreign Scholars Speak at Students’ Event")
                Spacer(modifier = Modifier.height(10.dp))

            }

        Image(painter = painterResource(id = R.drawable.forei1), contentDescription = "")


            Text(text = "The Institute of Electrical and Electronic Engineers (IEEE) of the Technical University of Kenya student branch, on Friday 17 th May 2024 held a workshop that was addressed by distinguished academics from recognized universities globally. TU-K joined the world’s largest Technical Professional Organization IEEE, in the year 2020 and became the 7th University in Kenya to be a member of the Association. The international academics included; Prof. Atif Samim from Saudi Arabia, Prof. Cristiano Tomassoni from Italy, Prof. Carlos Lopez Martinez from Spain and Prof. Shiban Koul from India.\n" +
                    "\n" +
                    "Various topics were addressed for example; transmission lines for high speed/high frequency integrated circuits, basics of SAR polarimetry, Additive Manufacturing: Emerging Opportunities for Microwave Components. The guests were received by Ag. Deputy Vice-Chancellor in charge of Academic and Student Affairs (ASA), Prof. Francis Gatheri who noted that the visit was important to the university. He informed them that TU-K was looking forward to more collaborations in its pursuit to remain a leading university of technology in Kenya.\n" +
                    "\n" +
                    "He thanked IEEE for providing the latest models of training in continuing education in engineering, technology and therefore ensuring that technologists stay relevant in their fast-changing industries.\n" +
                    "\n" +
                    "Prof. Samim explained that the institute will offer an enabling environment for the technological community to share information that will help students acquire knowledge and skills on critical, game-changing innovations in the emerging fields of Artificial Intelligence, Quantum Computing, sustainable energy and much more.\n" +
                    "\n" +
                    "He emphasised that IEEE was committed to fostering an environment of collaboration and engagement in support of its members by championing emerging technologies and embracing key challenges. This, he added, will ensure that members will have an impact in the world and therefore making it more prosperous.\n" +
                    "\n" +
                    "Also present was IEEE TU-K Branch Councilor, Dr. Mary Ahuna, who noted that the branch echoes TU-K’s readiness to lead the next technological revolution. The Branch comprises students and staff from the Faculty of Engineering and Built Environment (FEBE) and Faculty of Applied Sciences and Technology (FAST). ")
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.forei2) , contentDescription = "")
        Text(text = " IEEE TU-K branch covers different areas among them; Electrical and Electronic Engineering, Computer Engineering and Computer Science, Biomedical Engineering, Information and Communication Technologies, Aerospace & Defense, Artificial Intelligence, Automotive Engineering, Biomedical Engineering, Information Technology, and many others.")
        }
}
@Preview
@Composable
fun FoeriPreview(){
    ForeignScholars(rememberNavController())
}