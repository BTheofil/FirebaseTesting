package hu.tb.firebasetesting

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainViewModel : ViewModel() {

    private val firebase = Firebase.database.reference

    fun writeData() {
        firebase.child("users").child("2").setValue(User( name = "jakab", height = 180))
        //firebase.child("users").child("name").setValue("andras")
    }

    fun readData() {
        firebase.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val response = snapshot.child("1")
                Log.d("MYTAG", response.toString())
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}