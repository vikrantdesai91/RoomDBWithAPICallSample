package com.example.roomdbwithapicall.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Keep
data class UsersModel(
    @SerializedName("users") val users: List<User>?
) {

    @Entity(tableName = "user_table")
    @Keep
    data class User(
        @PrimaryKey(autoGenerate = true)
        @SerializedName("id") val id: Int?, // 1
        @SerializedName("firstName") val firstName: String?, // Emily
        @SerializedName("image") val image: String?, // https://dummyjson.com/icon/emilys/128
        @SerializedName("lastName") val lastName: String?, // Johnson
        @SerializedName("phone") val phone: String?, // +81 965-431-3024
    )
}