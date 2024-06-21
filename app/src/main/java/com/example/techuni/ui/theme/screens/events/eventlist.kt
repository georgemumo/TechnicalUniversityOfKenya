package com.example.techuni.ui.theme.screens.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar
import com.example.we_can.screens.actions.events.EventViewModel

@Composable
fun EventListScreen(navController: NavController, eventViewModel: EventViewModel = viewModel()) {


    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        floatingActionButton = {
            androidx.compose.material3.FloatingActionButton(onClick = {
                navController.navigate(
                    ROUTE_REGISTER
                )
            }) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.Create,
                    contentDescription = null
                )
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

            val events by eventViewModel.events.observeAsState(initial = emptyList())

            LaunchedEffect(Unit) {
                eventViewModel.fetchEvents()
            }


            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(events) { event ->
                    EventItem(event,eventViewModel)
                }

            }


        }
        }

    }


@Composable
fun EventItem(event: Event,eventViewModel: EventViewModel) {
    var isEditing by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf(TextFieldValue(event.title)) }
    var description by remember { mutableStateOf(TextFieldValue(event.description)) }

    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        if (isEditing) {
            BasicTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            BasicTextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Row {
                Button(onClick = {
                    isEditing = false
                    val updatedEvent = event.copy(title = title.text, description = description.text)
                    eventViewModel.updateEvent(updatedEvent)
                }) {
                    Text("Save")
                }
                Button(onClick = {
                    isEditing = false
                    title = TextFieldValue(event.title)
                    description = TextFieldValue(event.description)
                }) {
                    Text("Cancel")
                }
            }
        } else {
            Text(text = event.title, style = MaterialTheme.typography.h6)
            Text(text = event.description, style = MaterialTheme.typography.body1)
            if (event.imageUrl.isNotEmpty()) {
                Image(
                    painter = rememberImagePainter(event.imageUrl),
                    contentDescription = null,
                    modifier = Modifier.height(200.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Row {
                Button(onClick = { isEditing = true }) {
                    Text("Edit")
                }
                Button(onClick = { eventViewModel.deleteEvent(event.id) }) {
                    Text("Delete")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun EventListScreenPreview() {
    MaterialTheme {
        EventListScreen(rememberNavController())
    }
}