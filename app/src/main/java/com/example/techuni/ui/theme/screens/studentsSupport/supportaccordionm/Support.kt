package com.example.techuni.ui.theme.screens.studentsSupport.supportaccordion

import androidx.compose.ui.graphics.vector.ImageVector

data class Support(
    val tittle:String,
    val imageRes:Int,
    val description :String,
    val tips:List<String>,
    val icons :List<ImageVector>
)
