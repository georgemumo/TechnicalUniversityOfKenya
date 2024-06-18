package com.example.techuni.ui.theme.screens.events
import EventViewModel
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.techuni.navigation.ROUTE_EVENTS
import com.example.techuni.ui.theme.TechUniTheme


@Composable
fun EventScreen(navController: NavController,eventViewModel: EventViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Save Event", style = MaterialTheme.typography.h5)
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = { imagePickerLauncher.launch("image/*") }) {
            Text("Pick Image")
        }
        imageUri?.let { uri ->
            Image(
                painter = rememberImagePainter(uri),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
        }
        Button(
            onClick = {
                if (title.isNotBlank() && description.isNotBlank() && imageUri != null) {
                    eventViewModel.saveEvent(title, description, imageUri!!,

                    )
                    navController.navigate(ROUTE_EVENTS)
                }
            }
        ) {
            Text("Save Event")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigate to EventListScreen to display saved events
        // Replace with your navigation logic
        // EventListScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TechUniTheme {
        EventScreen(rememberNavController())
    }
}