package com.roque.mvvmsample.presentation.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roque.mvvmsample.presentation.viewmodel.GithubUsersViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GithubUsersViewModelModule {
    @Singleton
    @Provides
    internal fun provideViewModelProviderFactory(
        viewModel: GithubUsersViewModel
    ): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(viewModel.javaClass)) {
                    return viewModel as T
                }
                throw IllegalArgumentException("unexpected viewModel class $modelClass")
            }
        }
    }
}