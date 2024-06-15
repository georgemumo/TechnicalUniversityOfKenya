package com.example.techuni.navigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String){
    data object Home: NavigationItem("home", Icons.Filled.Home, "Home")
    data object Action: NavigationItem("action", Icons.Filled.CheckCircle, "Action")
    data object Data: NavigationItem("data", Icons.Filled.Warning, "Data")
    data object Profile: NavigationItem("profile", Icons.Filled.Person, "Profile")
}