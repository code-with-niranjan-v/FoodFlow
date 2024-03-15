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
import com.example.foodflow.databinding.FragmentSignUpBinding
import com.example.foodflow.models.User
import com.example.foodflow.viewmodel.UserAuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID

@AndroidEntryPoint
class SignUpFragment : Fragment() {

    private lateinit var signUpBinding: FragmentSignUpBinding
    private val userAuthViewModel: UserAuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        signUpBinding = FragmentSignUpBinding.inflate(layoutInflater,container,false)
        return signUpBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signUpBinding.btnSubmit.setOnClickListener {
            val email = signUpBinding.etEmail.text.toString()
            val name = signUpBinding.etName.text.toString()
            val password = signUpBinding.etPassword.text.toString()
            val phoneNumber = signUpBinding.etPhoneNumber.text.toString()
            val confirmPassword = signUpBinding.etConfirm.text.toString()
            val charityName = signUpBinding.etCharityName.text.toString()
            val uid = UUID.randomUUID().toString()
            val cityName = signUpBinding.etCityName.text.toString()
            val user = User(name,email, uid,phoneNumber.toInt(), cityName, charityName)
            

            if (email.isNotEmpty() && password.isNotEmpty() && phoneNumber.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (password == confirmPassword){
                    userAuthViewModel.createUserWithPassword(email, password,user,::onUserCreatedSuccessFully)
                }
            }
        }
    }

    private fun onUserCreatedSuccessFully():Unit{
        Toast.makeText(requireContext(),"Account Created Successfully!",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
    }




}