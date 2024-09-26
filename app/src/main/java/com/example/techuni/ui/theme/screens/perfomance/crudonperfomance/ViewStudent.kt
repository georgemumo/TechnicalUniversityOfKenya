package com.example.techuni.ui.theme.screens.perfomance.crudonperfomance

import android.icu.text.DecimalFormat
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.techuni.Drawer
import com.example.techuni.R
import com.example.techuni.navigation.ROUTE_REGISTER
import com.example.techuni.navigation.navigation.BottomNavigationBar
import com.example.techuni.navigation.navigation.TopBar

//import com.example.techuni.ui.theme.screens.perfomance.Performance

@Composable
fun ViewStudentsScreen(viewModel: StudentViewModel, navController: NavHostController) {
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
        Box(modifier = Modifier.padding(padding)) {
            val students by viewModel.students.observeAsState(emptyList())
            var searchQuery by remember { mutableStateOf("") }
            var filteredStudents by remember { mutableStateOf(students) }
            LaunchedEffect(searchQuery, students) {
                filteredStudents = if (searchQuery.isBlank()) {
                    students
                } else {
                    students.filter { it.name.contains(searchQuery, ignoreCase = true) }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                        filteredStudents = if (searchQuery.isEmpty()) {
                            students
                        } else {
                            students.filter { student -> student.name.contains(searchQuery, ignoreCase = true) }
                        }
                    },
                    label = { Text("Search by Name") }
                )

                if (filteredStudents.isEmpty() && searchQuery.isNotEmpty()) {
                    Text("No results found")
                } else {
                    LazyColumn {
                        items(filteredStudents) { student ->
                            StudentRow(student = student, viewModel = viewModel)
                        }
                    }
                }
            }

        }
        }

}

@Composable
fun StudentRow(student: Student, viewModel: StudentViewModel) {
    var isEditing by remember { mutableStateOf(false) }

    // State variables for each subject marks
    var mathMarks by remember { mutableStateOf(student.performances.find { it.Subject == "Mathematics" }?.marks?.toString() ?: "") }
    var englishMarks by remember { mutableStateOf(student.performances.find { it.Subject == "English" }?.marks?.toString() ?: "") }
    var kiswahiliMarks by remember { mutableStateOf(student.performances.find { it.Subject == "Kiswahili" }?.marks?.toString() ?: "") }
    var biologyMarks by remember { mutableStateOf(student.performances.find { it.Subject == "Biology" }?.marks?.toString() ?: "") }
    var chemistryMarks by remember { mutableStateOf(student.performances.find { it.Subject == "Chemistry" }?.marks?.toString() ?: "") }
    var physicsMarks by remember { mutableStateOf(student.performances.find { it.Subject == "Physics" }?.marks?.toString() ?: "") }

    // Calculate total and average marks
    val totalMarks = student.performances.sumBy { it.marks }
    val averageMarks = student.performances.map { it.marks }.average()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Gray))
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(student.name)
            Text("Total Marks: $totalMarks")
            Text("Average Marks: ${DecimalFormat("#.##").format(averageMarks)}")
            if (isEditing) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    LazyRow {
                        item {
                            PerformanceItem("Mathematics", mathMarks) { mathMarks = it }
                        }
                        item {
                            PerformanceItem("English", englishMarks) { englishMarks = it }
                        }
                        item {
                            PerformanceItem("Kiswahili", kiswahiliMarks) { kiswahiliMarks = it }
                        }
                        item {
                            PerformanceItem("Biology", biologyMarks) { biologyMarks = it }
                        }
                        item {
                            PerformanceItem("Chemistry", chemistryMarks) { chemistryMarks = it }
                        }
                        item {
                            PerformanceItem("Physics", physicsMarks) { physicsMarks = it }
                        }
                    }
                    Button(onClick = {
                        val updatedStudent = student.copy(
                            performances = listOf(
                                Perfomance("Mathematics", mathMarks.toIntOrNull() ?: 0),
                                Perfomance("English", englishMarks.toIntOrNull() ?: 0),
                                Perfomance("Kiswahili", kiswahiliMarks.toIntOrNull() ?: 0),
                                Perfomance("Biology", biologyMarks.toIntOrNull() ?: 0),
                                Perfomance("Chemistry", chemistryMarks.toIntOrNull() ?: 0),
                                Perfomance("Physics", physicsMarks.toIntOrNull() ?: 0)
                            )
                        )
                        viewModel.updateStudent(updatedStudent)
                        isEditing = true
                    }) {
                        Text("Save")
                    }
                }
            }
            Button(
                onClick = { isEditing = !isEditing },
                colors = ButtonDefaults.buttonColors(if (isEditing) Color.Red else Color.Blue)
            ) {
                Text(if (isEditing) "Cancel" else "Edit")
            }

            Button(
                onClick = { viewModel.deleteStudent(student.id) },
                colors = ButtonDefaults.buttonColors(Color.Magenta)
            ) {
                Text("Delete")
            }


        }
    }
}

@Composable
fun PerformanceItem(subject: String, marks: String, onMarksChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(subject)
        TextField(
            value = marks,
            onValueChange = onMarksChange,
            label = { Text("$subject Marks") }
        )
    }
}