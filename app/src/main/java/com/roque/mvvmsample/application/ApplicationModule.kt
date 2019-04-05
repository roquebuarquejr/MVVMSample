package com.roque.mvvmsample.application

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext(app: MVVMSampleApplication): Context {
        return app.applicationContext
    }

}