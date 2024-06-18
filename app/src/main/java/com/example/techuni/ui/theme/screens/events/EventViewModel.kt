import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
//import com.example.techuni.Event
import com.example.techuni.ui.theme.screens.events.Event
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventViewModel : ViewModel() {

    val events: LiveData<List<Event>> get() = _events
    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("events")
    private val storageReference: StorageReference = FirebaseStorage.getInstance().reference.child("event_images")
    private val _events = MutableLiveData<List<Event>>()
    fun saveEvent(title: String, description: String, imageUri: Uri) {
        val fileReference = storageReference.child("${System.currentTimeMillis()}_${imageUri.lastPathSegment}")

        fileReference.putFile(imageUri)
            .addOnSuccessListener { taskSnapshot ->
                fileReference.downloadUrl.addOnSuccessListener { uri ->
                    val imageUrl = uri.toString()
                    val id = databaseReference.push().key ?: ""
                    val event =  Event(id, title, description, imageUrl)
                    databaseReference.child(id).setValue(event)

                }
            }
            .addOnFailureListener { e ->
                // Handle error
            }
    }

    fun fetchEvents() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                databaseReference.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val eventList = mutableListOf<Event>()
                        for (data in snapshot.children) {
                            val event = data.getValue(Event::class.java)
                            event?.let { eventList.add(it) }
                        }
                        _events.postValue(eventList)
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle database error
                    }
                })
            }
        }
    }
}
