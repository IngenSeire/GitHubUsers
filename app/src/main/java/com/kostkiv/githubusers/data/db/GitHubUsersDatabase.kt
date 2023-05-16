package com.kostkiv.githubusers.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kostkiv.githubusers.data.UserDbModel

@Database(entities = [UserDbModel::class], version = 1, exportSchema = false)
abstract class GitHubUsersDatabase : RoomDatabase() {

    companion object {
        private val LOCK = Any()
        private const val DB_NAME = "users"
        private var db : GitHubUsersDatabase? = null

        fun getInstance(context : Context) : GitHubUsersDatabase {
            synchronized(LOCK) {
                db?.let {
                    return it
                }
                val instance = Room.databaseBuilder(context,
                GitHubUsersDatabase::class.java,
                DB_NAME).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun gitHubUsersDao() : GitHubUsersDao
}