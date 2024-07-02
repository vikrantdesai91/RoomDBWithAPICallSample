package com.example.roomdbwithapicall.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdbwithapicall.local.RoomDBHelper
import com.example.roomdbwithapicall.model.UsersModel
import com.example.roomdbwithapicall.repository.UserRepository
import com.example.sample.local.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel: ViewModel() {

    private var userListRepository = UserRepository()
    private var userDao: UserDao? = null

    fun init(requireContext: Context) {
        userListRepository = UserRepository()
        userDao = RoomDBHelper.DatabaseClient.getDatabase(requireContext).userDao()
    }

    fun setUserListRequest() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userListRepository.fetchUserList()?.let { response ->
                    try {
                        if (response.isSuccessful) {
                            Log.d("list", "setUserListRequest: ${response.body()?.users}")
                            Log.d("list", "setUserListRequest Size: ${response.body()?.users?.size}")
                            userDao?.insertUser(response.body()?.users ?: arrayListOf())
                        } else {
                            userDao?.insertUser(arrayListOf())
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        userDao?.insertUser(arrayListOf())
                    }
                }
            }
        }
    }

    fun getUserListRequest(): LiveData<List<UsersModel.User>>? {
        return userDao?.getUser()
    }

    fun updateUser(fName: String, lName: String, phone: String, id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userDao?.updateUser(fName, lName, phone, id)
            }
        }
    }

    fun deleteUser(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userDao?.deleteUserById(id)
            }
        }
    }

    fun addUser(user: UsersModel.User) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userDao?.addUser(user)
            }
        }
    }
}