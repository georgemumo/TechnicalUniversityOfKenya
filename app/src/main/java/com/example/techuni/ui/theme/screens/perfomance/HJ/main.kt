package com.example.myapplication.ui.theme.HJ

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.techuni.navigation.ROUTE_VIEWSTUDENTSCREEN

@Composable
fun MainScreen(navController: NavController) {
    val rowsData = listOf(
        "Faculty of Engineering and the Built Environment (FEBE)" to listOf(
            " School of Electrical and Electronic Engineering " to ROUTE_VIEWSTUDENTSCREEN,
            "School of Architecture and Spatial Planning " to  ROUTE_VIEWSTUDENTSCREEN
        ),
        "Faculty of Social Sciences and Technology (FSST)" to listOf(
            "School of Business and Management Studies" to  ROUTE_VIEWSTUDENTSCREEN,
            "School of Creative Arts and Media" to  ROUTE_VIEWSTUDENTSCREEN
        )
    )

    Column {
        rowsData.forEach { (title, buttons) ->
            ExpandableRow(title = title, buttons = buttons, navController = navController)
        }
    }
}
