package com.example.roomdbwithapicall.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbwithapicall.model.UsersModel
import com.example.sample.local.UserDao

@Database(entities = [UsersModel.User::class], version = 1)
abstract class RoomDBHelper : RoomDatabase() {

    abstract fun userDao(): UserDao

    object DatabaseClient {
        private var INSTANCE: RoomDBHelper? = null

        fun getDatabase(context: Context): RoomDBHelper {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDBHelper::class.java,
                    "main_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}