package hu.tb.firebasetesting

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.UUID

class MainViewModel : ViewModel() {

    private val firebase = Firebase.database.reference

    private val auth: FirebaseAuth = Firebase.auth

    fun register() {
        auth.createUserWithEmailAndPassword("elso@gmail.com", "123456")
            .addOnCompleteListener {
                Log.d("MYTAG", auth.currentUser.toString())
            }

            .addOnSuccessListener {
                Log.d("MYTAG", auth.currentUser.toString())
            }
            .addOnFailureListener {

            }
    }

    fun writeData() {
        firebase.child("users").child(UUID.randomUUID().toString())
            .setValue(User(name = "jakab", height = 180))
        //firebase.child("users").child("name").setValue("andras")
    }

    fun readData() {
        firebase.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val response = snapshot.children.forEach {
                    //Log.d("MYTAG", it.toString())
                }
                Log.d("MYTAG", response.toString())
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                //Log.d("MYTAG", snapshot.toString())
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                //Log.d("MYTAG", snapshot.toString())
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                //Log.d("MYTAG", snapshot.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                //Log.d("MYTAG", error.toString())
            }
        })
    }
}