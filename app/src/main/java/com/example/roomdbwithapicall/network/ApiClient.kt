package com.example.roomdbwithapicall.network

import com.example.roomdbwithapicall.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private lateinit var retrofitBuild: Retrofit

    fun getRetrofitClient(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()

        val builder = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)

        return builder.addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create())).client(httpClient.build()).build()
    }
}