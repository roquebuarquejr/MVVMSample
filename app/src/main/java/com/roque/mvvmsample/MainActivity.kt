package com.roque.mvvmsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.roque.mvvmsample.presentation.GithubUsersViewModel
import com.roque.mvvmsample.presentation.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniRecyclerView()
        initViewModel()
    }

    private fun iniRecyclerView() {
        rcUsersMain.layoutManager = LinearLayoutManager(this)
    }

    private fun initViewModel() {
        /**
         * Create new ViewModel instance
         */
        val viewModel: GithubUsersViewModel by lazy {
            ViewModelProviders.of(
                this,
                GithubUsersViewModel.GithubUsersViewModelFactory(BuildConfig.BASE_URL)
            ).get(GithubUsersViewModel::class.java)
        }

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
