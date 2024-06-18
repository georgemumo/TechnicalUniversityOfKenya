package com.example.techuni.ui.theme.screens.events

import EventViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter

@Composable
fun EventListScreen(navController: NavController, eventViewModel: EventViewModel = viewModel()) {
    val events by eventViewModel.events.observeAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        eventViewModel.fetchEvents()
    }


        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(events) { event ->
                EventItem(event)
            }

        }
    }


@Composable
fun EventItem(event: Event) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
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

    }
}

@Preview(showBackground = true)
@Composable
fun EventListScreenPreview() {
    MaterialTheme {
        EventListScreen(rememberNavController())
    }
}