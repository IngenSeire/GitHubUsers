package com.kostkiv.githubusers.domain

class LoadListOfUsersUseCase(private val repository : GitHubUsersRepository) {
    suspend operator fun invoke(since : Int) {
        repository.loadListOfUsersFromServer(since)
    }
}