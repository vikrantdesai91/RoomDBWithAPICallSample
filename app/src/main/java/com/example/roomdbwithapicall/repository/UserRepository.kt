package com.example.roomdbwithapicall.repository

import com.example.roomdbwithapicall.model.UsersResponse
import com.example.roomdbwithapicall.network.ApiClient

class UserRepository {

    private val userApiServices by lazy {
        ApiClient.getApiServices()
    }

    suspend fun getUsersDetails(): UsersResponse {
        return userApiServices.getUsersDetails()
    }
}