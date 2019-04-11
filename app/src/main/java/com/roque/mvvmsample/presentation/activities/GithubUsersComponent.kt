package com.roque.mvvmsample.presentation.activities

import com.roque.mvvmsample.presentation.injection.ActivityModule
import com.roque.mvvmsample.presentation.injection.ActivityScope
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface GithubUsersComponent {

    fun inject(githubUsersActivity: GithubUsersActivity)
}