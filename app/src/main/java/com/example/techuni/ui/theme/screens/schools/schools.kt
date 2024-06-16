package com.example.techuni.ui.theme.screens.schools

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SchoolsScreen(navController: NavController){
    Text(text = "ShoolsScreen")

}
@Preview
@Composable
fun SchoolsScreenPreview(){
    SchoolsScreen(rememberNavController())
}