package com.example.techuni.navigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

open class NavDrawerItem(var route: String, var icon: ImageVector, var title: String) {
     object Home : NavDrawerItem("home", Icons.Filled.Home, "Home")
     object Music : NavDrawerItem("music", Icons.Filled.AddCircle, "Music")
//     object Movies : NavDrawerItem("movies", R.drawable.ic_movie, "Movies")
//     object Books : NavDrawerItem("books", R.drawable.ic_book, "Books")
//     object Profile : NavDrawerItem("profile", R.drawable.ic_profile, "Profile")
//     object Settings : NavDrawerItem("settings", R.drawable.ic_settings, "Settings")
}