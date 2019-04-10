package com.roque.mvvmsample.presentation.injection

import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull

@Module
class ActivityModule(@field:NotNull var activity: AppCompatActivity) {


    @Provides
    internal fun provideContext(): Context {
        return activity
    }

}