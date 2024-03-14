package com.example.foodflow.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodflow.R
import com.example.foodflow.databinding.FragmentSignInBinding
import com.example.foodflow.viewmodel.UserAuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private val userAuthViewModel:UserAuthViewModel by viewModels()
    private lateinit var signInBinding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        signInBinding = FragmentSignInBinding.inflate(layoutInflater,container,false)
        return signInBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signInBinding.btnSubmit.setOnClickListener {
            val email = signInBinding.etEmail.text.toString()
            val password = signInBinding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                userAuthViewModel.signIn(email, password).addOnSuccessListener {
                    findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
                }.addOnFailureListener {
                    Toast.makeText(requireContext(),it.message.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



}