package com.example.foodflow.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodflow.R
import com.example.foodflow.databinding.FragmentHomeBinding
import com.example.foodflow.models.FoodItem
import com.example.foodflow.ui.fragments.utils.FoodItemsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding.btnDonateFood.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_addFoodItemsFragment)
        }

        val indianFoodItems = listOf(
            FoodItem(
                name = "Paneer Tikka",
                quantity = 10,
                date = "2024-03-14",
                city = "Mumbai",
                description = "Marinated cottage cheese grilled to perfection.",
                imageUrl = "https://t4.ftcdn.net/jpg/04/75/65/21/360_F_475652107_Sx73qgHWljGylX5KRyDFeE46ftX0A4EE.jpg",
                location = "Local Restaurant, 123 ABC Street"
            ),
            FoodItem(
                name = "Chicken Biryani",
                quantity = 5,
                date = "2024-03-14",
                city = "Delhi",
                description = "Spicy rice dish with tender chicken pieces and aromatic spices.",
                imageUrl = "https://media.istockphoto.com/id/1345624336/photo/chicken-biriyani.jpg?s=612x612&w=0&k=20&c=adU_N0P-1SKMQLZu5yu7aPknfLLgbViI8XILqLP92A4=",
                location = "Street Food Vendor, XYZ Market"
            ),
            FoodItem(
                name = "Masala Dosa",
                quantity = 8,
                date = "2024-03-14",
                city = "Bangalore",
                description = "Thin, crispy crepe filled with spicy potato filling.",
                imageUrl = "https://media.istockphoto.com/id/909906350/photo/masala-dosa-south-indian-food.jpg?s=612x612&w=0&k=20&c=3CI-bw2NhYaX_t0-CZIXIIXsOygFcUaoGSmzbnVB-fU=",
                location = "South Indian Restaurant, 456 DEF Road"
            ),
            FoodItem(
                name = "Rogan Josh",
                quantity = 3,
                date = "2024-03-14",
                city = "Jaipur",
                description = "Flavorful lamb curry cooked with a blend of spices.",
                imageUrl = "https://media.istockphoto.com/id/1168154867/photo/indian-curd-rice-with-carrots-pomegranate-and-with-additional-tempering-of-spices-close-up-in.jpg?s=612x612&w=0&k=20&c=r2OMqBs5H-VPjKj9n0SwTKYoC0XQ0-8jhQZB1YY8obU=",
                location = "Local Eatery, GHI Nagar"
            ),
            FoodItem(
                name = "Gulab Jamun",
                quantity = 12,
                date = "2024-03-14",
                city = "Kolkata",
                description = "Soft, sweet dumplings soaked in sugar syrup.",
                imageUrl = "https://media.istockphoto.com/id/1194662949/photo/indian-dessert-or-sweet-dish-gulab-jamun-in-white-bowl-on-yellow-background.jpg?s=612x612&w=0&k=20&c=XAOQkQC-Mu-XXviGtWU6NTz8vZzT1sY0oaJQ4jWo2Fo=",
                location = "Sweet Shop, JKL Street"
            )
        )

        val adapter = FoodItemsAdapter(listOfItems = indianFoodItems, context = requireContext())
        homeBinding.rvFoodItems.layoutManager = LinearLayoutManager(requireContext())
        homeBinding.rvFoodItems.adapter = adapter
    }


}