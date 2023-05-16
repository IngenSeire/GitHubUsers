package com.kostkiv.githubusers.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kostkiv.githubusers.data.UserDbModel

@Dao
interface GitHubUsersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsers(users: List<UserDbModel>)

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<UserDbModel>>
}