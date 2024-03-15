package com.example.foodflow.firebase

import android.util.Log
import androidx.core.net.toUri
import com.example.foodflow.models.FoodItem
import com.example.foodflow.models.User
import com.example.foodflow.paths.Constants.FIRE_STORAGE_FOOD_IMAGE
import com.example.foodflow.paths.Constants.FIRE_STORE_PATH_FOOD_ITEMS
import com.example.foodflow.paths.Constants.FIRE_STORE_PATH_USER
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FoodFirebaseDatabase @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val fireStore: FirebaseFirestore,
    private val firebaseStorage: FirebaseStorage
){

    fun createUserWithEmailAndPassword(email:String,password:String,user: User = User()): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            Log.e("firebaseAuth","Account Created!")
            saveUser(user = user)
        }.addOnFailureListener {
            Log.e("firebaseAuth",it.message.toString())
        }
    }

    fun signIn(email: String,password: String) = firebaseAuth.signInWithEmailAndPassword(email, password)

    fun saveUser(user: User): Task<Void> {
        return fireStore.collection(FIRE_STORE_PATH_USER).document(user.uid).set(user)
    }

    fun postFoodItem(foodItem: FoodItem): Task<Void> {
        return fireStore.collection(FIRE_STORE_PATH_FOOD_ITEMS).document(foodItem.foodItemId).set(foodItem)
    }

    suspend fun getFoodItems():List<FoodItem>{
        val foodItems = mutableListOf<FoodItem>()
        fireStore.collection(FIRE_STORE_PATH_FOOD_ITEMS).get().addOnSuccessListener {
            for(foodItem in it){
                val foodItemData = foodItem.toObject(FoodItem::class.java)
                foodItems.add(foodItemData)

            }
        }.await()
        return foodItems
    }

    private fun uploadImage(foodItem: FoodItem){
        firebaseStorage.reference.child(FIRE_STORAGE_FOOD_IMAGE).child(foodItem.foodItemId).putFile(foodItem.imageUrl.toUri()).addOnSuccessListener {
            firebaseStorage.reference.child(FIRE_STORAGE_FOOD_IMAGE)
        }
    }

}