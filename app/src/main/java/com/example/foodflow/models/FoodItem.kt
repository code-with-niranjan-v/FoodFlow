package com.example.foodflow.models

data class FoodItem(
    val name:String = "",
    val quantity:Int = 0,
    val date:String = "",
    val city:String = "",
    val description:String = "",
    val imageUrl:String = "",
    val location:String = "",
    val time:String = "",
    val foodItemId:String = ""
){
    fun allDataIsNull(): Boolean {
        return name.isEmpty() &&
                quantity == 0 &&
                date.isEmpty() &&
                city.isEmpty() &&
                description.isEmpty() &&
                imageUrl.isEmpty() &&
                location.isEmpty() &&
                time.isEmpty() &&
                foodItemId.isEmpty()
    }
}
