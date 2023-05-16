package com.kostkiv.githubusers.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDetailed(
    val login : String,
    val userId : Int,
    val avatarUrl : String,
    val name : String?,
    val email : String?,
    val organization: String?,
    val followingCount: Int,
    val followersCount : Int,
    val accountCreated : String?
) : Parcelable

