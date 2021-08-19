package com.creators4u.ekart.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.creators4u.ekart.R
import com.creators4u.ekart.room.UserRepository
import com.creators4u.ekart.room.UserRoomDatabase
import com.creators4u.ekart.utils.Validation.validateEmail
import com.creators4u.ekart.utils.Validation.validatePhone
import com.creators4u.ekart.viewmodel.UserViewModel
import com.creators4u.ekart.viewmodel.UserViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var emailEditText: TextInputEditText
    lateinit var passwordEditText: TextInputEditText
    lateinit var emailTIL: TextInputLayout
    lateinit var passwordTIL: TextInputLayout
    lateinit var errorTv:TextView
    lateinit var loginBtn:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()

        loginBtn.setOnClickListener {
            val emailOrPhone=emailEditText.text.toString()
            val password=passwordEditText.text.toString()
            if(emailOrPhone.isBlank())
                emailTIL.error = getString(R.string.msg_enter_email)
            else if(password.isBlank())
                passwordTIL.error = getString(R.string.msg_enter_password)
            else if(validateEmail(emailOrPhone)|| validatePhone(emailOrPhone))
            {
                val repo= UserRepository(UserRoomDatabase.getDatabaseInstance(this))
                val viewModelFactory= UserViewModelFactory(repo)
                val viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
                viewModel.getUserData(emailOrPhone,password)
                viewModel.data.observe(this, Observer{
                    if(it.isEmpty())
                        errorTv.visibility= View.VISIBLE
                    else{
                        startActivity(Intent(this,HomeActivity::class.java))
                    }
                })
            }
            else{
                errorTv.visibility= View.VISIBLE
            }
        }


    }
    private fun initView()
    {emailEditText=findViewById(R.id.email)
        passwordEditText=findViewById(R.id.password)
        loginBtn=findViewById(R.id.login_button)
        emailTIL=findViewById(R.id.email_til)
        passwordTIL=findViewById(R.id.password_til)
        errorTv=findViewById(R.id.error)

    }
}