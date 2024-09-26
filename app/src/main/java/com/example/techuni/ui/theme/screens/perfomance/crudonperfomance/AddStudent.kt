package com.example.techuni.ui.theme.screens.perfomance.crudonperfomance

import androidx.compose.material3.Button
//import com.example.techuni.ui.theme.screens.perfomance.Performance
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.techuni.navigation.ROUTE_VIEWSTUDENTSCREEN

//import com.example.techuni.ui.theme.screens.perfomance.Performance


@Composable
fun AddStudentScreen(viewModel: StudentViewModel, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var mathMarks by remember { mutableStateOf("") }
    var englishMarks by remember { mutableStateOf("") }
    var kiswahiliMarks by remember { mutableStateOf("") }
    var biologyMarks by remember { mutableStateOf("") }
    var chemistryMarks by remember { mutableStateOf("") }
    var physicsMarks by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = mathMarks, onValueChange = { mathMarks = it }, label = { Text("Mathematics Marks") })
        TextField(value = englishMarks, onValueChange = { englishMarks = it }, label = { Text("English Marks") })
        TextField(value = kiswahiliMarks, onValueChange = { kiswahiliMarks = it }, label = { Text("Kiswahili Marks") })
        TextField(value = biologyMarks, onValueChange = { biologyMarks = it }, label = { Text("Biology Marks") })
        TextField(value = chemistryMarks, onValueChange = { chemistryMarks = it }, label = { Text("Chemistry Marks") })
        TextField(value = physicsMarks, onValueChange = { physicsMarks = it }, label = { Text("Physics Marks") })
        Button(
            onClick = {
                val student = Student(
                    name = name,
                    performances = listOf(
                        Perfomance("Mathematics", mathMarks.toIntOrNull() ?: 0),
                        Perfomance("English", englishMarks.toIntOrNull() ?: 0),
                        Perfomance("Kiswahili", kiswahiliMarks.toIntOrNull() ?: 0),
                        Perfomance("Biology", biologyMarks.toIntOrNull() ?: 0),
                        Perfomance("Chemistry", chemistryMarks.toIntOrNull() ?: 0),
                        Perfomance("Physics", physicsMarks.toIntOrNull() ?: 0)
                    )
                )
                viewModel.addStudent(student)
                navController.navigate(ROUTE_VIEWSTUDENTSCREEN)
            }
        ) {
            Text("SAVE STUDENT PERFOMANCE")
        }
    }
}
