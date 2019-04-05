package com.roque.mvvmsample.presentation.injection

import android.content.Context
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull

@Module
class ActivityModule {

    @NotNull
    lateinit var activity: AppCompatActivity

    fun ActivityModule(@NonNull activity: AppCompatActivity) {
        this.activity = activity
    }

    @Provides
    internal fun provideContext(): Context {
        return activity
    }

}