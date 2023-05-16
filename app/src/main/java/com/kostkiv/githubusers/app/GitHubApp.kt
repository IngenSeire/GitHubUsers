package com.kostkiv.githubusers.app

import android.app.Application
import com.kostkiv.githubusers.app.di.appModule
import com.kostkiv.githubusers.app.di.dataModule
import com.kostkiv.githubusers.app.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitHubApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GitHubApp)
            modules(domainModule, dataModule, appModule)
        }
    }
}