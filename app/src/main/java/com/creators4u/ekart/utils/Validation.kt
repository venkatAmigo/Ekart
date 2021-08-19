package com.creators4u.ekart.utils

import com.creators4u.ekart.utils.Constants.PASSWORD_PATTERN
import java.util.regex.Pattern

object Validation {
    fun validateEmail(email:String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun validatePhone(phone:String):Boolean
    {
        return android.util.Patterns.PHONE.matcher(phone).matches()
    }
    fun validatePassword(password:String):Boolean
    {
        val pattern= Pattern.compile(PASSWORD_PATTERN)
        val matcher=pattern.matcher(password)
        return matcher.matches()
    }
    fun validateConfirmPassword(password:String,cPassword:String):Boolean
    {
        return password==cPassword
    }

}