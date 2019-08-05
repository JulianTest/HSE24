package com.example.hse24.presentation.product

import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.hse24.R
import com.example.hse24.core.di.Injector
import com.example.hse24.domain.models.ProductDetails
import com.example.hse24.presentation.BaseActivity
import kotlinx.android.synthetic.main.product_details_activity.*
import javax.inject.Inject

class ProductDetailsActivity: BaseActivity(), ProductDetailsContract.View{
    @Inject
    lateinit var presenter: ProductDetailsPresenter
    override fun getProductId(): String {
        return intent.getStringExtra(PRODUCT_ID)
    }


    override fun showProductDetails(productDetails: ProductDetails) {
        Glide.with(this).load(productDetails.imageUrl).into(image)
        name.text = productDetails.name
        price.text = ""+productDetails.price
        description.text = productDetails.description
        addBasket.setOnClickListener { presenter.addToBasket() }
    }

    companion object{
      const val PRODUCT_ID = "product.id"
    }
    override fun getLayoutResId(): Int {
        return R.layout.product_details_activity
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

    override fun showBasketSuccess() {
        //todo switch button to remove
        Toast.makeText(this, "added to basket", Toast.LENGTH_LONG).show()
    }

    override fun showBasketError() {
        Toast.makeText(this, "error adding to basket", Toast.LENGTH_LONG).show()
    }

}