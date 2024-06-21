package com.example.techuni.ui.theme.screens.perfomance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.techuni.R

@Composable
fun PerfomanceScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.back), contentDescription = "")
        Column(
            modifier = Modifier.fillMaxSize()) {
                Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text(text = "CHOOSE SCHOOL YOU BELONG")
                }
            Spacer(modifier = Modifier.height(10.dp))
            androidx.compose.material.Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = 10.dp,
                backgroundColor = Color.Cyan,
                shape = RoundedCornerShape(10.dp)
            ) {
               TextButton(onClick = { /*TODO*/ }) {
                   Text(text = "FACULTY OF ENGINEERING AND THE BUILT ENVIRONMENT (FEBE)")
               } 
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "FACULTY OF SOCIAL SCIENCES AND TECHNOLOGY (FSST)")
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "FACULTY OF APPLIED SCIENCES AND TECHNOLOGY (FAST)")
                    
                }

            }
            
        }
    }
 
    
}