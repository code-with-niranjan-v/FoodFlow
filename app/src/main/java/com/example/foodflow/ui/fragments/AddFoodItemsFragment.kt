package com.example.foodflow.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.fragment.app.viewModels
import com.example.foodflow.R
import com.example.foodflow.databinding.FragmentAddFoodItemsBinding
import com.example.foodflow.models.FoodItem
import com.example.foodflow.viewmodel.FoodItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class AddFoodItemsFragment : Fragment() {

    private lateinit var addFoodItemsBinding: FragmentAddFoodItemsBinding
    private lateinit var imageUrl:String
    private val foodItemViewModel:FoodItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        addFoodItemsBinding = FragmentAddFoodItemsBinding.inflate(layoutInflater,container,false)
        return addFoodItemsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val photoPicker = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){uri ->
            if (uri.toString().isNotEmpty()){
                imageUrl = uri.toString()
            }else{
                showMessage("Select Photo")
            }

        }

        addFoodItemsBinding.btnPhoto.setOnClickListener {
            photoPicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }



        addFoodItemsBinding.btnSubmit.setOnClickListener {
            val foodName = addFoodItemsBinding.etFoodName.text.toString()
            val quality = addFoodItemsBinding.etFoodQuantity.text.toString()
            val date = addFoodItemsBinding.etFoodDate.text.toString()
            val city = addFoodItemsBinding.etFoodCity.text.toString()
            val location = addFoodItemsBinding.etFoodLocation.text.toString()
            val description = addFoodItemsBinding.etFoodDescription.text.toString()
            val time = addFoodItemsBinding.etFoodTime.text.toString()

            val foodItem = FoodItem(foodName,quality.toInt(),date, city, description,imageUrl,location,time, foodItemId = UUID.randomUUID().toString())

            if(!foodItem.allDataIsNull()){
                foodItemViewModel.postFoodItem(foodItem,::showMessage)
            }
        }

    }

    private fun showMessage(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }


}