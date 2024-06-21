package com.example.techuni.ui.theme.screens.News.news

sealed class Screen(val route: String) {
    object Accordion : Screen("accordion")
    object Destination : Screen("destination")
}
