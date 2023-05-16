package com.kostkiv.githubusers.app.di

import com.kostkiv.githubusers.data.GitHubRepositoryImpl
import com.kostkiv.githubusers.data.GitHubUsersMapper
import com.kostkiv.githubusers.data.db.GitHubUsersDao
import com.kostkiv.githubusers.data.db.GitHubUsersDatabase
import com.kostkiv.githubusers.data.network.GitHubApiFactory
import com.kostkiv.githubusers.data.network.GitHubService
import com.kostkiv.githubusers.domain.GitHubUsersRepository
import org.koin.dsl.module

val dataModule = module {

    single<GitHubUsersRepository> {
        GitHubRepositoryImpl(get(), get(), get())
    }

    factory {
        GitHubUsersMapper()
    }

    single<GitHubService> {
        GitHubApiFactory.apiService
    }

    single<GitHubUsersDao> {
        GitHubUsersDatabase.getInstance(get()).gitHubUsersDao()
    }
}