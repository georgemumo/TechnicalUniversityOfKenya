package com.example.techuni.ui.theme.screens.News.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.techuni.R

@Composable
fun TransviewPhotos(navController: NavHostController) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .background(color = Color.White)) {
        Box {
            Text(text = "TU-K signs MoU with Transilvania University of Brașov")
        }
        Image(painter = painterResource(id = R.drawable.trans1), contentDescription = null)
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            Card(modifier = Modifier
                .height(130.dp)
                .width(200.dp)) {
                Image(painter = painterResource(id = R.drawable.transv2), contentDescription = "")
            }

            Spacer(modifier = Modifier.width(5.dp))
            Card (modifier = Modifier
                .height(130.dp)
                .width(200.dp)){
                Image(painter = painterResource(id = R.drawable.transv3) , contentDescription ="" )
            }

        }
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            Card(modifier = Modifier
                .height(130.dp)
                .width(200.dp)) {
                Image(painter = painterResource(id = R.drawable.transv4), contentDescription = "")
            }

            Spacer(modifier = Modifier.width(5.dp))
            Card (modifier = Modifier
                .height(130.dp)
                .width(200.dp)){
                Image(painter = painterResource(id = R.drawable.trans5) , contentDescription ="" )
            }

        }
    }
}