package com.creators4u.ekart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.creators4u.ekart.room.UserRepository

class UserViewModelFactory(val repo:UserRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repo) as T
    }
}