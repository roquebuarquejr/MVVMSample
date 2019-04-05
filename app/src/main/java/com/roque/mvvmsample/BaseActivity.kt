package com.roque.mvvmsample

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(getLayoutId())
        super.onCreate(savedInstanceState)

    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

}