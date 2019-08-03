package com.example.hse24.presentation

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hse24.R
import com.example.hse24.core.di.Injector
import com.example.hse24.domain.models.SimpleCategory
import com.example.hse24.presentation.categories.CategoryAdapter
import com.example.hse24.presentation.categories.CategoryContract
import com.example.hse24.presentation.categories.CategoryPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), CategoryContract.View {

    @Inject
    lateinit var presenter: CategoryPresenter

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun showCategories(categories: List<SimpleCategory>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CategoryAdapter(categories)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.appComponent.inject(this)
        presenter.setView(this)
        presenter.onBind()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onUnbind()
    }


}
