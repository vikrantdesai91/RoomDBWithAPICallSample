package com.example.sample.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.roomdbwithapicall.model.UsersModel

@Dao
interface UserDao {

    @Upsert
    suspend fun insertUser(user: List<UsersModel.User>)

    @Delete
    suspend fun deleteUser(user: UsersModel.User)

    @Insert
    suspend fun addUser(user: UsersModel.User)

    @Query("DELETE FROM user_table WHERE id = :userId")
    suspend fun deleteUserById(userId: Int)

    @Query(" SELECT * FROM user_table")
    fun getUser(): LiveData<List<UsersModel.User>>

    @Query(" update user_table SET firstName = :fName, lastName = :lName, phone = :phone where id = :id")
    fun updateUser(fName: String, lName: String, phone: String, id: Int)

}