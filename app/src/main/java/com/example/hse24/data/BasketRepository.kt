package com.example.hse24.data

import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import io.reactivex.Single

interface BasketRepository {
    fun addToBasket(productDetails: ProductDetails): Completable
    fun getBasket(): Single<List<ProductDetails>>
    fun removeFromBasket(productDetails: ProductDetails): Completable
}