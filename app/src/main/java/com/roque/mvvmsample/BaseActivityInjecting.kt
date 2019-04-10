package com.roque.mvvmsample

import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivityInjecting<Component> : AppCompatActivity() {


    private var component: Component? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        component = createComponent()
        onInject(this.component!!)
        super.onCreate(savedInstanceState)
    }

    fun getComponent(): Component? {
        return component
    }

    protected abstract fun onInject(component: Component)

    protected abstract fun createComponent(): Component
}