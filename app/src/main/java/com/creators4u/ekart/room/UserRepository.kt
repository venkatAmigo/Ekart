package com.creators4u.ekart.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepository(val db:UserRoomDatabase){

     fun insertUser(user:User)
    {
        db.getDao().insertUser(user)
    }
     fun getUser(email:String,password:String):List<User>
    {
        return db.getDao().getUser(email,password)

    }
}