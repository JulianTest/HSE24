package com.example.hse24.data

import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import io.reactivex.Single

interface BasketFromLocalDataSource {
    fun addToBasket(productDetails: ProductDetails): Completable
    fun basket(): Single<List<ProductDetails>>
    fun deleteFromBasket(productDetails: ProductDetails): Completable
}