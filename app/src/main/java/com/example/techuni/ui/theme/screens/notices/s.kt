package com.example.techuni.ui.theme.screens.events


import com.example.techuni.ui.theme.screens.notices.Notice
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await

object FirestoreUtil {

    private val db = FirebaseFirestore.getInstance()

    suspend fun saveNotice(notice: Notice) {
        db.collection("notices")
            .document(notice.id)
            .set(notice)
            .await()
    }

    suspend fun getNotices(): List<Notice> {
        val notices = mutableListOf<Notice>()
        val querySnapshot = db.collection("notices")
            .get()
            .await()
        for (document in querySnapshot.documents) {
            val notice = document.toObject<Notice>()
            notice?.let {
                notices.add(it)
            }
        }
        return notices
    }
}