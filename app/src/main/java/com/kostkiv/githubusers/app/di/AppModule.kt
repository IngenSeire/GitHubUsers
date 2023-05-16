package com.kostkiv.githubusers.app.di

import com.kostkiv.githubusers.app.presentation.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<UsersViewModel>() {
        UsersViewModel(get(), get(), get())
    }
}