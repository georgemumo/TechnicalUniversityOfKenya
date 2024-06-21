package com.example.we_can.screens.actions

import androidx.compose.ui.graphics.vector.ImageVector

data class News(
    val title: String,
    val imageRes: Int,
    val description: String,

    val icons: List<ImageVector>,
)
