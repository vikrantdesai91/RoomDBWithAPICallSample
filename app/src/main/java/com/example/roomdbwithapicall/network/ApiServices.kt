package com.example.roomdbwithapicall.network

import com.example.roomdbwithapicall.Utils.USER_END
import com.example.roomdbwithapicall.model.UsersModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET(USER_END)
    suspend fun getUsersDetails(): Response<UsersModel?>?
}