package com.kostkiv.githubusers.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.kostkiv.githubusers.data.db.GitHubUsersDao
import com.kostkiv.githubusers.data.network.GitHubService
import com.kostkiv.githubusers.domain.GitHubUsersRepository
import com.kostkiv.githubusers.domain.User
import com.kostkiv.githubusers.domain.UserDetailed

class GitHubRepositoryImpl(
    private val usersDao : GitHubUsersDao,
    private val mapper : GitHubUsersMapper,
    private val gitHubService: GitHubService
) : GitHubUsersRepository {

    override fun getListOfUsers(): LiveData<List<User>> {
        return usersDao.getAllUsers().map {
            mapper.mapListOfDbModelUsersToEntity(it)
        }
    }

    override suspend fun loadListOfUsersFromServer(since: Int) {
        val usersList = gitHubService.getUsers(since = since)
        usersDao.addUsers(usersList)
    }

    override suspend fun loadDetailedUserInfo(username: String): UserDetailed {
        return mapper.mapDbModelUserDetailedToEntity(gitHubService.getUserDetailedInfo(username))
    }
}