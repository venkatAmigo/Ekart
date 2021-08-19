package com.creators4u.ekart.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.creators4u.ekart.R
import com.creators4u.ekart.room.User
import com.creators4u.ekart.room.UserRepository
import com.creators4u.ekart.room.UserRoomDatabase
import com.creators4u.ekart.utils.Validation
import com.creators4u.ekart.utils.Validation.validateConfirmPassword
import com.creators4u.ekart.utils.Validation.validateEmail
import com.creators4u.ekart.utils.Validation.validatePassword
import com.creators4u.ekart.utils.Validation.validatePhone
import com.creators4u.ekart.viewmodel.UserViewModel
import com.creators4u.ekart.viewmodel.UserViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var emailEditText:TextInputEditText
    lateinit var phoneEditText:TextInputEditText
    lateinit var passwordEditText:TextInputEditText
    lateinit var confirmPasswordEditText:TextInputEditText

    lateinit var emailTIL:TextInputLayout
    lateinit var phoneTIL:TextInputLayout
    lateinit var passwordTIL:TextInputLayout
    lateinit var confirmPasswordTIL:TextInputLayout
    lateinit var signupBtn:AppCompatButton
    lateinit var loginBtnTv: TextView

    lateinit var email:String
    lateinit var phone:String
    lateinit var password:String
    lateinit var confirmPassword:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initView()

        signupBtn.setOnClickListener {
            email=emailEditText.text.toString()
            phone=phoneEditText.text.toString()
            password=passwordEditText.text.toString()
            confirmPassword=confirmPasswordEditText.text.toString()
            if(isValid())
            {
                val repo=UserRepository(UserRoomDatabase.getDatabaseInstance(this))
                val viewModelFactory=UserViewModelFactory(repo)
                val viewModel=ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
                viewModel.insertData(User(1,email,phone,password))
                startActivity(Intent(this,LoginActivity::class.java))
            }

        }

        loginBtnTv.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }
    private fun initView()
    {
        emailEditText=findViewById(R.id.email)
        phoneEditText=findViewById(R.id.phone)
        passwordEditText=findViewById(R.id.password)
        confirmPasswordEditText=findViewById(R.id.confirm_password)
        emailTIL=findViewById(R.id.email_til)
        phoneTIL=findViewById(R.id.phone_til)
        passwordTIL=findViewById(R.id.password_til)
        confirmPasswordTIL=findViewById(R.id.confirm_til)
        signupBtn=findViewById(R.id.signup_button)
        loginBtnTv=findViewById(R.id.login_button)
    }
    private fun isValid():Boolean {
        when {
            email.isBlank() -> {
                emailTIL.error = getString(R.string.msg_enter_email)
                return false
            }
            phone.isBlank() -> {
                phoneTIL.error = getString(R.string.msg_enter_phone)
                return false
            }
            password.isBlank() -> {
                passwordTIL.error = getString(R.string.msg_enter_password)
                return false
            }
            confirmPassword.isBlank() -> {
                confirmPasswordTIL.error = getString(R.string.msg_enter_cpassword)
                return false
            }
            !validateEmail(email)->{
                emailTIL.error = getString(R.string.msg_enter_valid_email)
                return false
            }
            !validatePhone(phone)->{
                phoneTIL.error = getString(R.string.msg_enter_valid_phone)
                return false
            }
            !validatePassword(password)->{
               passwordTIL.error =getString(R.string.msg_enter_valid_pwd)
                return false
            }

            !validateConfirmPassword(password,confirmPassword)->{
                confirmPasswordTIL.error = getString(R.string.msg_enter_valid_pwd)
                return false
            }
            else -> return true
        }
    }

}