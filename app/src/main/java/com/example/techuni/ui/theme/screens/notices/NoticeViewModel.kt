package com.example.techuni.ui.theme.screens.notices

import androidx.lifecycle.ViewModel

//import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techuni.ui.theme.screens.events.Event
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoticeViewModel : ViewModel() {
    private val _notices = MutableStateFlow<List<Notice>>(emptyList())
    val notices: StateFlow<List<Notice>> = _notices
    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("notices")

    init {
        fetchNotices()
    }

    private fun fetchNotices() {
        viewModelScope.launch {
            val noticeList = RealtimeDatabaseUtil.getNotices()
            _notices.value = noticeList
        }
    }



}
