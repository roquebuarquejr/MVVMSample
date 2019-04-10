package com.roque.mvvmsample.presentation.activities


import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.roque.mvvmsample.BaseActivityInjecting
import com.roque.mvvmsample.R
import com.roque.mvvmsample.application.MVVMSampleApplication

import com.roque.mvvmsample.presentation.viewmodel.GithubUsersViewModel
import com.roque.mvvmsample.presentation.adapter.UserAdapter
import com.roque.mvvmsample.presentation.injection.ActivityModule
import kotlinx.android.synthetic.main.activity_githubusers.*
import javax.inject.Inject

class GithubUsersActivityInjecting : BaseActivityInjecting<GithubUsersComponent>() {

    @Inject
    lateinit var viewModel:GithubUsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_githubusers)

        iniRecyclerView()
        initViewModel()
    }

    override fun onInject(component: GithubUsersComponent) {
        component.inject(this)
    }

    override fun createComponent(): GithubUsersComponent {
        val app = MVVMSampleApplication::class.java.cast(application)!!
        val activityModule = ActivityModule(this)
        return app.getComponent()!!.createActivityGithubUsers(activityModule)
    }

    private fun iniRecyclerView() {
        rcUsersMain.layoutManager = LinearLayoutManager(this)
    }

    private fun initViewModel() {
        /**
         * Starting observing userList liveData
         */
        viewModel.users.observe(this, Observer {
            /**
             * Checking if list empty or not
             */
            if (it?.isEmpty() == false) {
                rcUsersMain.adapter = UserAdapter(it)
            } else {
                viewFlipper.displayedChild = 1
            }
        })

        /**
         * Starting observing error liveData
         */
        viewModel.error.observe(this, Observer {
            Toast.makeText(this, "#erro", Toast.LENGTH_SHORT).show()
        })
    }

}
