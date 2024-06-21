package com.example.techuni.ui.theme.screens.notices

//import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavController
import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
//import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat
//import java.util.Local
import androidx.compose.ui.res.colorResource
//import androidx.navigation.NavController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.rememberImagePainter
//import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
//import com.google.type.Date
import java.util.Locale

//import androidx.navigation.NavController

@Composable
fun RetrieveNoticesScreen(navController: NavController) {
    val noticeViewModel: NoticeViewModel = viewModel()
    val notices by noticeViewModel.notices.collectAsState()
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
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize()) {

            Column(modifier = Modifier.padding(16.dp)) {
                val coroutineScope = rememberCoroutineScope()
                var notices by remember { mutableStateOf(emptyList<Notice>()) }

                LaunchedEffect(Unit) {
                    coroutineScope.launch {
                        notices = RealtimeDatabaseUtil.fetchNotices()
                    }
                }


                Text("Notices:")
                LazyColumn {
                    items(notices) { notice ->
                        NoticeItem(notice = notice)
                    }
                }
            }

        }
        }

}

@Composable
fun NoticeItem(notice: Notice) {
    var isEditing by remember {   mutableStateOf(false) }

       var date by remember { mutableStateOf(TextFieldValue(notice.day)) }
        var updatedTitle by remember { mutableStateOf(TextFieldValue(notice.tittle)) }
        var updatedDescription by remember { mutableStateOf(TextFieldValue(notice.description)) }

//        var description by remember { mutableStateOf(TextFieldValue(notice.description)) }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
//            elevation = 4.dp

        ) {
            Column (
                modifier = Modifier.padding(16.dp)
            ){
                if (isEditing){
                    OutlinedTextField(
                        value = updatedTitle,
                        onValueChange ={updatedTitle=it},
                        label = { Text(text = "Tittle")},
                        modifier = Modifier.fillMaxWidth()
                        )
                    OutlinedTextField(
                        value =updatedDescription ,
                        onValueChange = {updatedDescription=it},
                        label = { Text(text = "Description")},
                        modifier = Modifier.fillMaxWidth()
                        )
                    Row (
                        modifier = Modifier.fillMaxWidth()
                        , horizontalArrangement = Arrangement.End
                    ){
                       Button(onClick = {
                           isEditing=false
                           RealtimeDatabaseUtil.updateNotice(
                               Notice(
                                   id = notice.id,
                                   tittle = updatedTitle.text,
                                   description = updatedDescription.text,
//                                   date = notice.date,
                                   day = notice.day
                               )
                           )
                       }) {
                                Text(text = "Save")
                        }
                    }

            }else {
                Text(notice.tittle, style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = notice.description,
                        style = MaterialTheme.typography.body2,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                        )
                    Spacer(modifier = Modifier.height(4.dp))
//                    Text(text =notice.date?.toDate()?.formatDate() ?:"",
//                        style = MaterialTheme.typography.caption
//                        )
                    if (notice.imageUrl.isNotBlank()) {
                        // Display image if available
                         Image(
                             painter = rememberImagePainter(notice.imageUrl),
                             contentDescription = "Notice Image",
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                         )
                        Spacer(modifier = Modifier.height(8.dp))
                }
                    Row (modifier = Modifier.fillMaxWidth(), 
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        androidx.compose.material3.Button(onClick = {isEditing=true })
                        {
                        Text(text = "Edit")    
                        }
                        androidx.compose.material3.Button(onClick = { RealtimeDatabaseUtil.deleteNotice(notice.id)}) {
                            Text(text = "Delete")
                            
                        }
                    }
                        
                    }
                    

        }

        }
}

//private fun Any.toDate(): Any {
//    val date = this.toDate()
//    val format = java.text.SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
//    return format.format(date)
//
//}
//
//fun Any?.formatDate(): String? {
//    val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
//    return format.format(this)
//
//}
//
