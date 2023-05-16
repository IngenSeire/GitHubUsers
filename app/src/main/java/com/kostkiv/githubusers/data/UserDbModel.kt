package com.kostkiv.githubusers.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserDbModel(
    @SerializedName("login")
    val login : String,
    @SerializedName("id")
    @PrimaryKey
    val userId : Int,
    @SerializedName("avatar_url")
    val avatarUrl : String
)

