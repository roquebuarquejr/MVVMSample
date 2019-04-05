package com.roque.mvvmsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.roque.mvvmsample.data.GithubUser
import com.roque.mvvmsample.data.Service
import com.roque.mvvmsample.presentation.viewmodel.GithubUsersViewModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GithubUsersViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var service: Service
    @Mock
    private lateinit var users: Observer<List<GithubUser>>
    @Mock
    private lateinit var error: Observer<Throwable>

    private lateinit var viewModel: GithubUsersViewModel

    private var arrangeBuilder: ArrangeBuilder? = null

    @Before
    fun setup(){
        arrangeBuilder = ArrangeBuilder()
        viewModel = GithubUsersViewModel(service)

        viewModel.users.observeForever(users)
        viewModel.error.observeForever(error)
    }


    @Test
    fun shouldFetchUsersWithSuccessful() {
        // given
        Mockito.`when`(service.getGithubUsers()).thenReturn(Single.just(getUsers()))

        // when
        viewModel.fetchUsers()

        // then
        Mockito.verify(users).onChanged(viewModel.users.value)
    }

    @Test
    fun shouldFetchUsersWithError() {
        // given
        Mockito.`when`(service.getGithubUsers()).thenReturn(Single.error(Throwable()))

        // when
        viewModel.fetchUsers()

        // then
        Mockito.verify(error).onChanged(viewModel.error.value)
    }

    private fun getUsers() = arrayListOf(GithubUser())


    private inner class ArrangeBuilder {
        internal var interactorSubject = Single.just(listOf(GithubUser()))
        init {
            Mockito.`when`(service.getGithubUsers()).thenReturn(interactorSubject)
        }

    }

}