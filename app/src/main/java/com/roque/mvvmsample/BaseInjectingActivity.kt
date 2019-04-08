package com.roque.mvvmsample

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity

abstract class BaseInjectingActivity<Component> : AppCompatActivity() {

    @Nullable
    private var component: Component? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        component = createComponent()
        onInject(this.component!!)
        super.onCreate(savedInstanceState)
    }


    @NonNull
    fun getComponent(): Component? {
        return component
    }

    protected abstract fun onInject(@NonNull component: Component)

    @NonNull
    protected abstract fun createComponent(): Component
}