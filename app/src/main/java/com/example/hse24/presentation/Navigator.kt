package com.example.hse24.presentation

import android.app.Activity
import android.content.Intent
import com.example.hse24.presentation.product.ProductDetailsActivity
import com.example.hse24.presentation.product.ProductListActivity

fun Activity.navigateToProductList(categoryId: Int){
    val intent = Intent(this, ProductListActivity::class.java).apply {
        putExtra(ProductListActivity.CATEGORY_ID, categoryId)
    }
    startActivity(intent)
}

fun Activity.navigateToProductDetails(productId: String){
    val intent = Intent(this, ProductDetailsActivity::class.java).apply {
        putExtra(ProductDetailsActivity.PRODUCT_ID, productId)
    }
    startActivity(intent)
}