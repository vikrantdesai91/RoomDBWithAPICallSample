package com.example.roomdbwithapicall.network

import com.example.roomdbwithapicall.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private lateinit var retrofitBuild: Retrofit

    fun getApiServices(): ApiServices {
        if (!this::retrofitBuild.isInitialized) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            retrofitBuild = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofitBuild.create(ApiServices::class.java)
    }
}