package com.kostkiv.githubusers.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubApiFactory {

    private const val BASE_URL = "https://api.github.com/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: GitHubService by lazy {
        retrofit.create(GitHubService::class.java)
    }
}