package com.example.foodflow.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.foodflow.R
import com.example.foodflow.databinding.FragmentGetStartedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetStartedFragment : Fragment() {

    private lateinit var getStartedBinding: FragmentGetStartedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        getStartedBinding = FragmentGetStartedBinding.inflate(layoutInflater,container,false)
        return getStartedBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController =  findNavController()

        getStartedBinding.btnGetStarted.setOnClickListener {
            navController.navigate(R.id.action_getStartedFragment_to_signUpFragment)
        }

        getStartedBinding.btnLogin.setOnClickListener {
            navController.navigate(R.id.action_getStartedFragment_to_signInFragment)
        }

    }


}