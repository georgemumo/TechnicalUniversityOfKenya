package com.example.techuni.ui.theme.screens.AboutTuk

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.example.techuni.navigation.ROUTE_ACCORDION_ITEM
import com.example.techuni.navigation.ROUTE_NEWSABOUTTUK
import com.example.we_can.screens.actions.News
//import com.example.we_can.navigation.ROUTE_POST
import com.example.we_can.screens.actions.Topic
import okhttp3.Route

@Composable
fun NewsAccordionItem(news: News, navController: NavController,) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        color = if (expanded) MaterialTheme.colorScheme.surface else Color.DarkGray,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .animateContentSize()
            .clickable { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (expanded) Icons.Default.ArrowDropDown else Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = news.title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily.Monospace,
                )
            }
            if (expanded) {
                Column(modifier = Modifier) {


                    Image(
                        painter = painterResource(id = news.imageRes),
                        contentDescription = news.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(vertical = 8.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        news.icons.forEach { icon ->
                            IconButton(onClick = {
                                navController.navigate(ROUTE_NEWSABOUTTUK)
                            }) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }
                    }
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Red), // Light red color
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = news.description,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                }
            }
        }
    }
}
