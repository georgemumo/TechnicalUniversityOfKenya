package com.example.techuni.ui.theme.screens.notices

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.techuni.navigation.ROUTE_RETRIEVENOTICE
import com.google.firebase.storage.FirebaseStorage
import java.util.*
//import android.net.Uri
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
import kotlinx.coroutines.launch

//import android.net.Uri
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import coil.compose.rememberImagePainter
//import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

@Composable
fun SaveNoticeScreen(navController: NavController) {
    val currentDate=Long
    var description by remember { mutableStateOf("") }
    var tittle by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var videoUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val imagePickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
    }
    var day by remember { mutableStateOf("") }

    val videoPickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        videoUri = uri
    }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = tittle,
            onValueChange = { tittle = it },
            label = { Text("Tittle") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = day,
            onValueChange = { day = it },
            label = { Text("Date of event") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
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
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { videoPickerLauncher.launch("video/*") }) {

            Text("Pick Video")

        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (day.isNotBlank() && imageUri != null && videoUri != null  ) {
                    val notice = Notice(
                        id = UUID.randomUUID().toString(),
                        day = day,
//                        date =currentDate,
                        description = description,
                        imageUrl = "",
                        videoUrl = ""
                    )
                    coroutineScope.launch {
                        saveNotice(notice, imageUri!!, videoUri!!)
                        navController.navigate(ROUTE_RETRIEVENOTICE)
                    }
                } else {
                    // Show error message to the user
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Notice")
        }
    }
}

private suspend fun saveNotice(notice: Notice, imageUri: Uri, videoUri: Uri) {
    val storage = FirebaseStorage.getInstance()
    val imageRef = storage.reference.child("images/${notice.id}.jpg")
    val videoRef = storage.reference.child("videos/${notice.id}.mp4")

    val imageUploadTask = imageRef.putFile(imageUri)
    val videoUploadTask = videoRef.putFile(videoUri)

    imageUploadTask.await()
    videoUploadTask.await()

    val imageUrl = imageRef.downloadUrl.await().toString()
    val videoUrl = videoRef.downloadUrl.await().toString()

    val noticeWithUrls = notice.copy(imageUrl = imageUrl, videoUrl = videoUrl)

    RealtimeDatabaseUtil.saveNotice(noticeWithUrls)
}
