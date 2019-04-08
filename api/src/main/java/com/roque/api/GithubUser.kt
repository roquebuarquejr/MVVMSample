package com.roque.api

import com.google.gson.annotations.SerializedName


open class GithubUser {
    @SerializedName("login")
    var login: String = ""
    @SerializedName("avatar_url")
    var avatar: String = ""
}