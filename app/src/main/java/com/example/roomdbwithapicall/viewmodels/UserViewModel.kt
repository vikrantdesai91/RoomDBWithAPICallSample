package com.example.roomdbwithapicall.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdbwithapicall.model.UsersResponse
import com.example.roomdbwithapicall.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    private val userRepo by lazy {
        UserRepository()
    }

    private val _users = MutableLiveData<UsersResponse>()
    val users: LiveData<UsersResponse> = _users

    fun fetchUserDetails() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                userRepo.getUsersDetails().let {
                    _users.postValue(it)
                }
            }
        } catch (e: Exception) {

        }
    }
}