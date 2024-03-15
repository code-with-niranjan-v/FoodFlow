package com.example.foodflow.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodflow.firebase.FoodFirebaseDatabase
import com.example.foodflow.models.FoodItem
import com.example.foodflow.repository.FoodItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodItemViewModel @Inject constructor(
    private val repository: FoodItemsRepository
):ViewModel() {

    private var foodItemsList:MutableLiveData<List<FoodItem>> = MutableLiveData()
    fun postFoodItem(foodItem: FoodItem, onShowMessage:(String)->Unit) = CoroutineScope(Dispatchers.IO).launch {
        repository.postFoodItems(foodItem).addOnSuccessListener {
            onShowMessage("Food Item Posted Successfully!")
        }.addOnFailureListener{
            onShowMessage(it.message.toString())
        }


    }

    fun loadFoodItems(){
        foodItemsList.value = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch{
            foodItemsList.postValue(repository.getFoodItems())
        }
    }

    fun getFoodItems():MutableLiveData<List<FoodItem>> = foodItemsList

}