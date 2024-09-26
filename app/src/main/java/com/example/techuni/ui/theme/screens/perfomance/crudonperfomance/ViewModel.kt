package com.example.techuni.ui.theme.screens.perfomance.crudonperfomance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
class StudentViewModel : ViewModel() {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference.child("studentsperfomance")

    private val _students = MutableLiveData<List<Student>>(emptyList())
    val students: LiveData<List<Student>> get() = _students
    init {
        loadStudents()
    }
    fun addStudent(student: Student) {
        database.child(student.id).setValue(student)
            .addOnSuccessListener { loadStudents() }
            .addOnFailureListener { /* Handle failure */ }
    }

    fun updateStudent(student: Student) {
        database.child(student.id).setValue(student)
            .addOnSuccessListener { loadStudents() }
            .addOnFailureListener { /* Handle failure */ }
    }

    fun deleteStudent(studentId: String) {
        database.child(studentId).removeValue()
            .addOnSuccessListener { loadStudents() }
            .addOnFailureListener { /* Handle failure */ }
    }

    fun loadStudents() {
        database.get().addOnSuccessListener { snapshot ->
            val studentsList = snapshot.children.mapNotNull { it.getValue(Student::class.java) }
            _students.value = studentsList
        }
    }

    fun searchStudent(name: String): Student? {
        return students.value?.find { it.name.equals(name, ignoreCase = true) }
    }
}
