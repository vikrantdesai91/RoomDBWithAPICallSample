package com.example.roomdbwithapicall.network

import com.example.roomdbwithapicall.Utils.USER_END
import com.example.roomdbwithapicall.model.UsersResponse
import retrofit2.http.GET

interface ApiServices {
    @GET(USER_END)
    suspend fun getUsersDetails(): UsersResponse
}