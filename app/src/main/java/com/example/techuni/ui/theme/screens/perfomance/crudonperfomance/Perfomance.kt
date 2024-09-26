package com.example.techuni.ui.theme.screens.perfomance.crudonperfomance

//import com.example.techuni.ui.theme.screens.perfomance.Performance
import java.util.UUID

data class Perfomance (
    val Subject:String="",
    val marks :Int =0
)
data class Student(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val performances: List< Perfomance> = emptyList()
) {
    constructor() : this("", "", emptyList())
    val totalMarks: Int
        get() = performances.sumBy { it.marks }
    val averageMarks: Float
        get() = if (performances.isNotEmpty()) performances.sumBy { it.marks } / performances.size.toFloat() else 0f
}