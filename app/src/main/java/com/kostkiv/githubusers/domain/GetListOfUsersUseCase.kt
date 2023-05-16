package com.kostkiv.githubusers.domain

import androidx.lifecycle.LiveData

class GetListOfUsersUseCase(private val repository : GitHubUsersRepository) {
    operator fun invoke() : LiveData<List<User>> {
        return repository.getListOfUsers()
    }
}