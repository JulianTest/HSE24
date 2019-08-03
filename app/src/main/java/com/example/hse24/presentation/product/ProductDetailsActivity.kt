package com.example.hse24.presentation.product

import com.example.hse24.R
import com.example.hse24.presentation.BaseActivity

class ProductDetailsActivity: BaseActivity(){
    companion object{
      const val PRODUCT_ID = "product.id"
    }
    override fun getLayoutResId(): Int {
        return R.layout.product_details_activity
    }

}