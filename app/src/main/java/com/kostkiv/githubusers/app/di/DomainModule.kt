package com.kostkiv.githubusers.app.di

import com.kostkiv.githubusers.domain.GetDetailedInfoAboutUser
import com.kostkiv.githubusers.domain.GetListOfUsersUseCase
import com.kostkiv.githubusers.domain.LoadListOfUsersUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetListOfUsersUseCase(get())
    }

    factory {
        GetDetailedInfoAboutUser(get())
    }

    factory {
        LoadListOfUsersUseCase(get())
    }
}