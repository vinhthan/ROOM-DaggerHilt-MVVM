package com.example.roomdatabasedaggerhiltmvvm.database

import javax.inject.Inject

class RoomRepository @Inject constructor(private val userDao: UserDao) {

    fun getUser(): List<UserEntity>{
        return userDao.getUsers()
    }

    fun insertUser(userEntity: UserEntity) {
        userDao.insertUser(userEntity)
    }
}