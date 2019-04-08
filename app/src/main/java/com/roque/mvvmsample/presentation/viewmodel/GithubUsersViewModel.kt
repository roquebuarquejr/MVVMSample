package com.roque.mvvmsample.presentation.viewmodel

import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roque.api.GithubUser
import com.roque.api.RetrofitConfig.Companion.createApi
import com.roque.api.Service
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GithubUsersViewModel @Inject constructor(private val service: Service) : ViewModel() {

    @NonNull
    private val compositeDisposable = CompositeDisposable()

    val users = MutableLiveData<List<GithubUser>>()
    val error = MutableLiveData<Throwable>()

    init {
        compositeDisposable.add(fetchUsers())
    }

    fun fetchUsers(): Disposable {
        return service.getGithubUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::updateUsers, ::displayError)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    private fun updateUsers(list: List<GithubUser>) {
        users.postValue(list)
    }

    private fun displayError(t: Throwable) {
        error.postValue(t)
    }
}

