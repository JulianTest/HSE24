package com.example.hse24.core.mvp

interface BaseView {
    fun showContent(isVisible: Boolean)
    fun showLoading(isVisible: Boolean)
    fun showError(isVisible: Boolean)


    //can be used if there is no custom behavior e.g. alert for error shown over content
    fun showLoading() {
        showLoading(true)
        showError(false)
        showContent(false)
    }

    fun showError() {
        showLoading(false)
        showError(true)
        showContent(false)
    }

    fun showContent() {
        showLoading(false)
        showError(false)
        showContent(true)
    }
}