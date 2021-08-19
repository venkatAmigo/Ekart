package com.creators4u.ekart.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserRoomDatabase:RoomDatabase() {
    abstract fun getDao():UserDao

    companion object
    {

        //Creating Singleton RoomDatabase Intsance
        @Volatile
        var instance:UserRoomDatabase?=null
        fun getDatabaseInstance(context: Context):UserRoomDatabase
        {
            val temp=instance
            if(temp!=null)
                return temp
            synchronized(this){
                val newInstance= Room.databaseBuilder(context.applicationContext,UserRoomDatabase::class.java,"user_db")
                    .build()
                instance=newInstance
                return newInstance
            }

        }
    }
}