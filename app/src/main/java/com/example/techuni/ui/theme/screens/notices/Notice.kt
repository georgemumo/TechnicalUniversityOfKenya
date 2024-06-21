package com.example.techuni.ui.theme.screens.notices

import java.util.UUID

data class Notice(
    val id: String = UUID.randomUUID().toString(),
//    val date: String="",
    val tittle:String="",
    val day:String="",
    val imageUrl: String = "",
    val videoUrl: String = "",
    val description: String = ""
)
