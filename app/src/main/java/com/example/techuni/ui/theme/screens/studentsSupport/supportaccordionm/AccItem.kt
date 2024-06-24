package com.example.techuni.ui.theme.screens.studentsSupport.supportaccordion

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//import com.example.techuni.ui.theme.screens.perfomance.crudonperfomance.Student

@Composable
fun StudentAccordionItem(support: Support,navController: NavController){
    var open by remember { mutableStateOf(false)  }
    val context = LocalContext.current
    Surface (
        color = if (open)androidx.compose.material3.MaterialTheme.colorScheme.surface else Color.DarkGray,
        shape = RoundedCornerShape(9.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .animateContentSize()
            .clickable { open = !open }
    ){
        Column(modifier = Modifier
            .padding(16.dp)
            .background(color = Color.Magenta)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (open) Icons.Default.ArrowDropDown else Icons.Default.Add,

                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                    )
                Text(text = support.tittle,
                    color = Color.White,
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    fontFamily =  FontFamily.Serif
                    )
            }
            if (open){
                Column (modifier = Modifier){
                    Image(
                        painter = painterResource(id = support.imageRes),
                        contentDescription =support.tittle,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(vertical = 8.dp)
                            .clip(RoundedCornerShape(8.dp))
                        )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        var isFavouriteSelected by remember {   mutableStateOf(false)                       }
                        IconButton(onClick = {  isFavouriteSelected = !isFavouriteSelected }) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "favourite",
                                tint = if (isFavouriteSelected)Color.Magenta else Color.Transparent
                                )
                        }
                        IconButton(onClick = { Toast.makeText(context,"You Clicked Add Icon",Toast.LENGTH_SHORT).show()}
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription ="Add" )
                        }
                        IconButton(onClick = { Toast.makeText(context,"You clicked CheckCircle icon ",Toast.LENGTH_SHORT).show() }) {
                            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Check")
                        }

                    }
                }

            }
        }

    }
}