package com.example.foodflow.ui.fragments.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.foodflow.databinding.FoodItemsListBinding
import com.example.foodflow.models.FoodItem

class FoodItemsViewHolder(private val binding: FoodItemsListBinding):ViewHolder(binding.root) {

    fun bindData(foodItem: FoodItem,context: Context){
        Glide.with(context)
            .load(foodItem.imageUrl)
            .centerCrop()
            .into(binding.imgFood)

        binding.tvFoodCity.text = foodItem.city
        binding.tvFoodName.text = foodItem.name
    }

}

class FoodItemsAdapter(
    private val listOfItems:List<FoodItem>,
    private val context: Context
):Adapter<FoodItemsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemsViewHolder {
        val binding = FoodItemsListBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )

        return FoodItemsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    override fun onBindViewHolder(holder: FoodItemsViewHolder, position: Int) {
        holder.bindData(listOfItems[position],context)
    }

}