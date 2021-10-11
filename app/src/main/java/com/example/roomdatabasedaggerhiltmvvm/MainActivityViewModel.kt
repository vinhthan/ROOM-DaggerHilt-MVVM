package com.example.roomdatabasedaggerhiltmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabasedaggerhiltmvvm.database.RoomRepository
import com.example.roomdatabasedaggerhiltmvvm.database.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val roomRepository: RoomRepository): ViewModel() {

    var userData: MutableLiveData<List<UserEntity>> = MutableLiveData()

    init {
        loadUser()
    }

    fun getUserObserver(): MutableLiveData<List<UserEntity>>{
        return userData
    }

    fun loadUser() {
        val list = roomRepository.getUser()
        userData.postValue(list)
    }

    fun insertUser(userEntity: UserEntity) {
        roomRepository.insertUser(userEntity)
        loadUser()
    }

}