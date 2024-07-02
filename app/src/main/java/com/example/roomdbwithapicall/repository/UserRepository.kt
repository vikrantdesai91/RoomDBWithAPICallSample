package com.example.roomdbwithapicall.repository

import com.example.roomdbwithapicall.model.UsersModel
import com.example.roomdbwithapicall.network.ApiClient
import com.example.roomdbwithapicall.network.ApiServices
import retrofit2.Response

class UserRepository {

    private var retrofitClientInterface: ApiServices? = null

    init {
        retrofitClientInterface = ApiClient.getRetrofitClient().create(ApiServices::class.java)
    }

    suspend fun fetchUserList(): Response<UsersModel?>? {
        return retrofitClientInterface?.getUsersDetails()
    }
}