package com.example.foodflow.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoodFirebaseDatabase @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val fireStore: FirebaseFirestore,
    private val firebaseStorage: FirebaseStorage
){

    fun createUserWithEmailAndPassword(email:String,password:String){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            Log.e("firebaseAuth","Account Created!")
        }.addOnFailureListener {
            Log.e("firebaseAuth",it.message.toString())
        }
    }

    fun signIn(email: String,password: String) = firebaseAuth.signInWithEmailAndPassword(email, password)

}