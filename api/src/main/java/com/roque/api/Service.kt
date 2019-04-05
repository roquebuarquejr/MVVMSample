package com.roque.api

import io.reactivex.Single
import retrofit2.http.GET

interface Service {

    @GET("users")
    fun getGithubUsers(): Single<List<GithubUser>>
}