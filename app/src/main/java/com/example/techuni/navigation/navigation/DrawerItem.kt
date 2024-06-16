package com.example.techuni.navigation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.techuni.R

@Composable
fun DrawerItem(item: NavDrawerItem,selected:Boolean,onItemClick:  (NavDrawerItem) -> Unit){

    val background = if (selected) R.color.purple_200 else android.R.color.transparent
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .background(color = Color.Gray)
            .padding(start = 10.dp)
    ){
        Image(
            painter = painterResource(R.drawable.logo1) ,
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.White),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
            )

        Spacer(modifier = Modifier.width(7.dp))
       Text(text = item.title,
           fontSize = 18.sp,
           color = Color.Black
           )

    }
}


@Preview(showBackground = false)
@Composable
fun DrawerItemPreview() {
    DrawerItem(item = NavDrawerItem.Home, selected = false, onItemClick = {})
}