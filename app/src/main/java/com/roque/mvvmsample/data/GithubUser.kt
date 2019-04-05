package com.roque.mvvmsample.data

import com.google.gson.annotations.SerializedName


open class GithubUser {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("login")
    var login: String = ""
    @SerializedName("avatar_url")
    var avatar: String = ""
}