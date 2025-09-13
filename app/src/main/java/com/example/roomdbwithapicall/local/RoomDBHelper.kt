package com.example.roomdbwithapicall.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomdbwithapicall.model.UsersModel
import com.example.sample.local.UserDao

@Database(entities = [UsersModel.User::class], version = 2, exportSchema = true)
abstract class RoomDBHelper : RoomDatabase() {

    companion object {
        // v1 -> v2 adds nullable TEXT column `email`
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE user_table ADD COLUMN email TEXT")
            }
        }
    }

    abstract fun userDao(): UserDao

    object DatabaseClient {
        private var INSTANCE: RoomDBHelper? = null

        fun getDatabase(context: Context): RoomDBHelper {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDBHelper::class.java,
                    "main_database"
                ).addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}