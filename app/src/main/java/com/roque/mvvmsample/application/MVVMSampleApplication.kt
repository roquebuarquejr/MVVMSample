package com.roque.mvvmsample.application

import android.app.Application
import androidx.annotation.NonNull

class MVVMSampleApplication : Application() {

    private var component: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        initComponent()?.inject(this)

    }

    @NonNull
    fun initComponent(): ApplicationComponent? {
        component?.let {
             component = DaggerApplicationComponent.builder().application(this).build()
        }
        return component
    }

}