package com.practice.room.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.practice.room.model.User

@Dao
interface UserDao {
// suspend - zawiesza
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addUser(user: User)


    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>
//Suspend jest bo uzywany courinties czy jakos tak
    @Update
    suspend fun updateUser(user: User)
}