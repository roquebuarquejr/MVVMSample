package com.roque.mvvmsample.data

import io.reactivex.Single
import retrofit2.http.GET

interface Service {

    @GET("users")
    fun getGithubUsers(): Single<List<GithubUser>>
}