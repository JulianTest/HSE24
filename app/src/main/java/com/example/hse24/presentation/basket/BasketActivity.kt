package com.example.hse24.presentation.basket

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hse24.R
import com.example.hse24.core.di.Injector
import com.example.hse24.domain.models.ProductDetails
import com.example.hse24.domain.models.ProductInfo
import com.example.hse24.presentation.BaseActivity
import com.example.hse24.presentation.product.ProductListAdapter
import kotlinx.android.synthetic.main.product_list_activity.*
import javax.inject.Inject

class BasketActivity : BaseActivity(), BasketContract.View{


    override fun getLayoutResId(): Int {
        return R.layout.basket_activity
    }

    @Inject
    lateinit var presenter: BasketPresenter

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
    override fun showProducts(products: List<ProductDetails>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BasketListAdapter(products)
    }


}