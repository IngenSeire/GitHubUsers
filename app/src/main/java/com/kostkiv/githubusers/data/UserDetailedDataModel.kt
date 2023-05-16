package com.kostkiv.githubusers.data

import com.google.gson.annotations.SerializedName

data class UserDetailedDataModel(
    @SerializedName("login")
    val login : String,
    @SerializedName("id")
    val userId : Int,
    @SerializedName("avatar_url")
    val avatarUrl : String,
    @SerializedName("name")
    val name : String?,
    @SerializedName("email")
    val email : String?,
    @SerializedName("company")
    val organization: String?,
    @SerializedName("following")
    val followingCount: Int,
    @SerializedName("followers")
    val followersCount : Int,
    @SerializedName("created_at")
    val accountCreated : String?
)

