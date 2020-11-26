package com.practice.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.practice.room.data.UserDatabase
import com.practice.room.repository.UserRepository
import com.practice.room.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

     val readAllData : LiveData<List<User>>
    private val repository : UserRepository
// init to block który zawsze jest uzywany gdy uservviewmodel jest 'called'
    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }


    fun addUser(user: User){
        // ta klasa to courintenes jakies
        //Dispatcher IO mowi zeby robic to w wątku w tle
        viewModelScope.launch(Dispatchers.IO ) {
            repository.addUser(user)
        }
    }


    fun updateUser(user: User){
        viewModelScope.launch( Dispatchers.IO){
            repository.updateUser(user)
        }
    }




}