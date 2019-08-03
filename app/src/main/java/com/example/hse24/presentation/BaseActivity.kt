package com.example.hse24.presentation

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.example.hse24.R
import com.example.hse24.core.mvp.BaseView
import kotlinx.android.synthetic.main.base_layout.*

abstract class BaseActivity: Activity(), BaseView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_layout)
        layoutInflater.inflate(getLayoutResId(), contentFrame)
    }

    abstract fun getLayoutResId(): Int

    override fun showContent(isVisible: Boolean) {
        contentFrame.showIf(isVisible)
    }

    override fun showLoading(isVisible: Boolean) {
        loading.showIf(isVisible)
    }

    override fun showError(isVisible: Boolean) {
        error.showIf(isVisible)
    }
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun View.showIf(isVisible: Boolean){
    if (isVisible)show() else hide()
}