package com.example.hse24.presentation

import android.os.Bundle
import com.example.hse24.R
import com.example.hse24.core.di.Injector
import com.example.hse24.presentation.categories.CategoryContract
import com.example.hse24.presentation.categories.CategoryPresenter
import javax.inject.Inject


class MainActivity : BaseActivity(), CategoryContract.View {
    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    @Inject
    lateinit var presenter: CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.appComponent.inject(this)
        presenter.setView(this)
        presenter.onBind()
    }

}
