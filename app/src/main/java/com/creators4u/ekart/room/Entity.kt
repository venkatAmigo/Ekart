package com.creators4u.ekart.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.creators4u.ekart.utils.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class User(@PrimaryKey(autoGenerate = true) val id:Int,
                @ColumnInfo(name="email") val email:String,
                @ColumnInfo(name="phone") val phone:String,
                @ColumnInfo(name="password") val password:String
                )