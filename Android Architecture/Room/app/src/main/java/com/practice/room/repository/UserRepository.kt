package com.practice.room.repository

import androidx.lifecycle.LiveData
import com.practice.room.data.UserDao
import com.practice.room.model.User

//A repository class abstracts access to multiple data sources

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()


   suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
}