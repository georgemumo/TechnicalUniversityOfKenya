package com.example.techuni.ui.theme.screens.News

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.techuni.R

@Composable
fun ForestScreen(navController: NavHostController) {
    Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        Column (
            Modifier
                .background(color = Color.White)
                .verticalScroll(rememberScrollState())
        ){
            Image(painter = painterResource(id = R.drawable.cover), contentDescription = null)
            Text(
                text = "The Technical University of Kenya has partnered with the Kenya Forestry Service (KFS) in a joint effort to grow tree seedlings. The initiative will greatly contribute towards the Government’s target of planting 15 billion trees in 10 years.\n" +
                        "\n" +
                        "On 10th May 2024, The University, together with KFS, for the second time, jointly planted 1200 tree seedlings at Konza Technopolis City consisting an assortment of indigenous trees. The day had been declared a public holiday by the Government for Kenyans to plant trees and also to honour people who lost lives during the recent flashfloods.\n" +
                        "\n" +
                        "The Deputy Vice Chancellor, Institutional Advancement & Enterprise, Prof. Paul Wambua, who joined members of staff and student in the tree planting exercise, lauded the joint effort between TU-K and KFS, as well as Konza City for providing and preparing the ground for tree growing exercise."
            )
            Image(painter = painterResource(id = R.drawable.cover1), contentDescription = "")

        }
    }
}