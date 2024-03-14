package com.example.foodflow.models

data class FoodItem(
    val name:String,
    val quantity:Int,
    val date:String,
    val city:String,
    val description:String,
    val imageUrl:String,
    val location:String
)
