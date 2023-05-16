package com.kostkiv.githubusers.domain

class GetDetailedInfoAboutUser(private val repository : GitHubUsersRepository) {
    suspend operator fun invoke(username : String) : UserDetailed {
        return repository.loadDetailedUserInfo(username)
    }
}