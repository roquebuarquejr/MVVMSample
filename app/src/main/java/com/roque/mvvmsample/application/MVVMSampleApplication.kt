package com.roque.mvvmsample.application

import android.app.Application
import androidx.annotation.NonNull

class MVVMSampleApplication : Application() {

    private var component: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        getComponent()?.inject(this)

    }

    @NonNull
    fun getComponent(): ApplicationComponent? {
        if (component == null) {
            component = DaggerApplicationComponent.builder().application(this).build()
        }
        return component
    }

}