package com.example.foodflow.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.foodflow.R
import com.example.foodflow.databinding.FragmentSignUpBinding
import com.example.foodflow.viewmodel.UserAuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

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
            val password = signUpBinding.etPassword.text.toString()
            val phoneNumber = signUpBinding.etPhoneNumber.text.toString()
            val confirmPassword = signUpBinding.etConfirm.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && phoneNumber.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (password == confirmPassword){
                    userAuthViewModel.createUserWithPassword(email, password)
                }
            }
        }
    }




}