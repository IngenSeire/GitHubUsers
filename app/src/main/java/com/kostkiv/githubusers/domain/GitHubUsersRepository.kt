package com.kostkiv.githubusers.domain

import androidx.lifecycle.LiveData

interface GitHubUsersRepository {

    fun getListOfUsers() : LiveData<List<User>>

    suspend fun loadListOfUsersFromServer(since : Int)

    suspend fun loadDetailedUserInfo(username : String) : UserDetailed

}