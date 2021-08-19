package com.creators4u.ekart.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.creators4u.ekart.room.User
import com.creators4u.ekart.room.UserRepository
import com.creators4u.ekart.room.UserRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(val userRepository: UserRepository): ViewModel() {

    var data: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData(email:String,password:String)
    {
        viewModelScope.launch(Dispatchers.IO){
            val res=userRepository.getUser(email,password)
            withContext(Dispatchers.Main)
            {
                data.value = res
            }
        }
    }
    fun insertData(user:User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.insertUser(user)
        }
    }
}