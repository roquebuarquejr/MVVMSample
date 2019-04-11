package com.roque.mvvmsample


import androidx.test.runner.AndroidJUnit4
import com.roque.mvvmsample.presentation.activities.GithubUsersActivity
import org.junit.runner.RunWith
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import org.junit.Rule
import org.junit.Before
import org.junit.Test

import androidx.test.rule.ActivityTestRule
import com.roque.api.GithubUser
import com.roque.mvvmsample.presentation.adapter.UserAdapter


@RunWith(AndroidJUnit4::class)
open class GithubUsersInstrumentedTest {

    //Activity
    lateinit var activity: GithubUsersActivity

    //ResId
    var resId: Int = R.id.rcUsersMain

    lateinit var recyclerView: RecyclerView

    var itemCount: Int = 0

    lateinit var adapter: UserAdapter

    @get:Rule
    val rule: ActivityTestRule<GithubUsersActivity> =
        object : ActivityTestRule<GithubUsersActivity>(GithubUsersActivity::class.java) {

            override fun getActivityIntent(): Intent {
                val intent = Intent()
                val extras = Bundle()
                intent.putExtras(extras)
                return intent
            }
        }

    @Before
    fun setup() {
        activity = rule.activity
        adapter = UserAdapter(getUsers())
        recyclerView = activity.findViewById(resId)

    }

    @Test
    fun recyclerViewTest() {

    }

    private fun getUsers():List<GithubUser>{
        val user = GithubUser()
        user.login = "Instrumented test"

        return listOf(user)
    }

}