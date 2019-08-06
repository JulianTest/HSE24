package com.example.hse24.core.mvp

interface BasePresenter<in V : BaseView> {
    fun onBind()
    fun onUnbind()
    fun setView(baseView: V)

}