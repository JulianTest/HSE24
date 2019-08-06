package com.example.hse24.data

import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import io.reactivex.Single

class BasketDatabase {

    //todo should use actual database like Room or Realm, Deletes should use ID not complete object
    private val products = ArrayList<ProductDetails>()

    fun addToBasket(productDetails: ProductDetails): Completable {
        return Completable.fromCallable { products.add(productDetails) }
    }

    fun removeFromBasket(productDetails: ProductDetails): Completable {
        return Completable.fromCallable { products.remove(productDetails) }
    }

    fun getBasket(): Single<List<ProductDetails>> = Single.fromCallable { products }
}