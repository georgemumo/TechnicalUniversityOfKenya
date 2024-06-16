package com.example.techuni.navigation.navigation


import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.techuni.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//import com.example.we_can.R
//
//@Composable
//fun TopBar(scope:CoroutineScope,scaffoldState: ScaffoldState){
//    TopAppBar(
//        backgroundColor = Color.DarkGray,
//    ) {
//
//        Image(
//            painter = painterResource(id = R.drawable.logo1),
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.width(220.dp))
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                imageVector = Icons.Filled.ThumbUp,
//                contentDescription = null,
//                modifier = Modifier.padding(end = 8.dp)
//
//            )
//        }
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                imageVector = Icons.Filled.Settings,
//                contentDescription = null, )
//        }
//    }
//}
//@Preview
//@Composable
//fun TopAppPreview(){
//    TopApp()
//}
@Composable
fun TopBar(scope:CoroutineScope, scaffoldState: ScaffoldState){
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp)},
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        backgroundColor = colorResource(id = R.color.purple_200)
    )

}
@Preview(showBackground = false)
@Composable
fun TopBarPreview(){
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(androidx.compose.material.DrawerValue.Closed))
    TopBar(scope = scope, scaffoldState = scaffoldState)
}
