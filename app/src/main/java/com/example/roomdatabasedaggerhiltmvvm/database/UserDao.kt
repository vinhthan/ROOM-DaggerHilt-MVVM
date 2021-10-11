package com.example.roomdatabasedaggerhiltmvvm.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user_entity ORDER BY id DESC")
    fun getUsers(): List<UserEntity>

    @Insert
    fun insertUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)
}