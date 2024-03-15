package com.example.foodflow.models

data class FoodOrder(
    val orderId: String = "",
    val items: MutableList<FoodItem> = mutableListOf(),
    val user: User = User(),
    val donour:User = User()
)
