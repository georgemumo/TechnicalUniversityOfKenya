package com.example.techuni.ui.theme.screens.notices


//import androidx.lifecycle.viewModelScope
import com.example.techuni.ui.theme.screens.events.Event
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
//import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
//import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

object RealtimeDatabaseUtil:ViewModel() {


    private val db = FirebaseDatabase.getInstance().reference
    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("notices")
    private val _notices = MutableStateFlow<List<Notice>>(emptyList())
    val notices: StateFlow<List<Notice>> = _notices
    suspend fun saveNotice(notice: Notice) {
        db.child("notices").child(notice.id).setValue(notice).await()
    }
    suspend fun fetchNotices(): List<Notice> {
        return try {
            val snapshot = databaseReference.get().await()
            snapshot.children.mapNotNull { it.getValue(Notice::class.java) }
        } catch (e: Exception) {
            emptyList()
        }
    }
    suspend fun getNotices(): List<Notice> {
        val snapshot = db.child("notices").get().await()
        return snapshot.children.mapNotNull { it.getValue<Notice>() }
    }
    fun updateNotice(notice: Notice) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                databaseReference.child(notice.id).setValue(notice)
            }
        }
    }
    fun deleteNotice(noticeId: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                databaseReference.child(noticeId).removeValue()
            }
        }
    }

}
