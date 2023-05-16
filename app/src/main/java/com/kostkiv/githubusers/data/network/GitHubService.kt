package com.kostkiv.githubusers.data.network

import com.kostkiv.githubusers.data.UserDbModel
import com.kostkiv.githubusers.data.UserDetailedDataModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {

    @GET("users")
    suspend fun getUsers(
        @Query("per_page") perPage : Int = 10,
        @Query("since") since : Int
    ) : List<UserDbModel>

    @GET("users/{username}")
    suspend fun getUserDetailedInfo(
        @Path("username") username : String
    ) : UserDetailedDataModel
}