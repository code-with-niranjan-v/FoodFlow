package com.example.foodflow.repository

import com.example.foodflow.firebase.FoodFirebaseDatabase
import com.example.foodflow.models.FoodItem
import javax.inject.Inject


class FoodItemsRepository @Inject constructor(
    private val firebase:FoodFirebaseDatabase
) {

    suspend fun postFoodItems(foodItem: FoodItem) = firebase.postFoodItem(foodItem)
    suspend fun getFoodItems() = firebase.getFoodItems()

}