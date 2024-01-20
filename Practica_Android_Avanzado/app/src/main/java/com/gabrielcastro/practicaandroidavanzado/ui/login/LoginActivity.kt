package com.gabrielcastro.practicaandroidavanzado.ui.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.gabrielcastro.practicaandroidavanzado.MainActivity
import com.gabrielcastro.practicaandroidavanzado.R
import com.gabrielcastro.practicaandroidavanzado.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel : LoginViewModel by viewModels()
    private val TAG_EMAIL = "MyEmail"
    private val TAG_PASSWORD = "MyPassword"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadDataFromPreferences()

        viewModel.login.observe(this){
            Log.d("LOGIN", it.toString())
            if(binding.cbSaveData.isChecked){
                saveDataInPreferences(binding.etEmail.text.toString(),binding.etPassword.text.toString())
                launchMainActivity()
            }else{
                launchMainActivity()
            }
        }

        binding.btLogin.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if(!email.isEmpty() && !password.isEmpty()){
                viewModel.performLogin(email,password)
            }else{
                binding.etEmail.error = "This field is empty or the email is invalid"
            }
        }
    }

    private fun launchMainActivity(){
        MainActivity.launch(this)
    }

    //Save in saveInPreferences
    private fun saveDataInPreferences(mail: String, pass: String) {
        getPreferences(Context.MODE_PRIVATE).edit().apply {
            putString(TAG_EMAIL, mail).apply()
            putString(TAG_PASSWORD, pass).apply()

        }
    }
    //Retrieve
    private fun loadDataFromPreferences() {
        getPreferences(Context.MODE_PRIVATE).apply {
            binding.etEmail.setText(getString(TAG_EMAIL, ""))
            binding.etPassword.setText(getString(TAG_PASSWORD, ""))
            if (binding.etEmail.text.toString() != "" && binding.etPassword.text.toString() != "") {
                binding.cbSaveData.isChecked = true
            }
        }
    }
}