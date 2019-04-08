package com.roque.mvvmsample.application

import com.roque.mvvmsample.presentation.injection.GithubUsersViewModelModule
import dagger.Module

@Module(includes = [GithubUsersViewModelModule::class])
class ViewModelModule

