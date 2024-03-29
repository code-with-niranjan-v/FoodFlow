package com.example.foodflow.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foodflow.firebase.FoodFirebaseDatabase
import com.example.foodflow.models.FoodItem
import com.example.foodflow.models.User
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserAuthViewModel @Inject constructor(
    private val firebase: FoodFirebaseDatabase
):ViewModel() {

    fun createUserWithPassword(email:String,password:String,user:User = User(),onSuccess:()->Unit = {}){
        CoroutineScope(Dispatchers.IO).launch {
            firebase.createUserWithEmailAndPassword(email, password,user).addOnSuccessListener {
                onSuccess()
            }
        }
    }

    fun signIn(email: String,password: String) = firebase.signIn(email,password,)




}