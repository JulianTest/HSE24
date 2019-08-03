package com.example.hse24.presentation.product

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hse24.R
import com.example.hse24.core.di.Injector
import com.example.hse24.domain.models.ProductInfo
import com.example.hse24.presentation.BaseActivity
import kotlinx.android.synthetic.main.product_list_activity.*
import javax.inject.Inject

class ProductListActivity : BaseActivity(), ProductListContract.View{

    companion object{
        const val CATEGORY_ID = "category.id"
    }

    override fun getLayoutResId(): Int {
        return R.layout.product_list_activity
    }

    override fun getCategoryId(): Int {
        return intent.getIntExtra(CATEGORY_ID, 0)
    }

    @Inject
    lateinit var presenter: ProductListPresenter

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

    override fun showProductList(it: List<ProductInfo>) {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = ProductListAdapter(it)
    }

}