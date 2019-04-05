package com.roque.mvvmsample.data

import org.jetbrains.annotations.NotNull

class Repository {

    //TODO INJECT ME
    @NotNull
    private var service: Service = RetrofitConfig.createApi("https://api.github.com/")

}