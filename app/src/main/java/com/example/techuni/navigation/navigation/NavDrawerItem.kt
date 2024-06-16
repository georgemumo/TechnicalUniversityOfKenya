package com.example.techuni.navigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

open class NavDrawerItem(var route: String, var icon: ImageVector, var title: String) {
     object Home : NavDrawerItem("home", Icons.Filled.Home, "Home")
     object Music : NavDrawerItem("aboutTUK", Icons.Filled.AddCircle, "About TUK")
     object News :NavDrawerItem("news",Icons.Filled.AddCircle,"News")
     object StudentCouncil :NavDrawerItem("Student",Icons.Filled.Person,"StudentCouncil")
     object Schools :NavDrawerItem("school",Icons.Filled.Home,"Schools")
     object hostels :NavDrawerItem("hostel",Icons.Filled.AddCircle,"Hostels")
//     object Movies : NavDrawerItem("movies", R.drawable.ic_movie, "Movies")
//     object Books : NavDrawerItem("books", R.drawable.ic_book, "Books")
//     object Profile : NavDrawerItem("profile", R.drawable.ic_profile, "Profile")
//     object Settings : NavDrawerItem("settings", R.drawable.ic_settings, "Settings")
}