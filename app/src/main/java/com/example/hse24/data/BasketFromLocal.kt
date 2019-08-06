package com.example.hse24.data

import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BasketFromLocal @Inject constructor(private val basketDatabase: BasketDatabase) : BasketFromLocalDataSource {
    override fun deleteFromBasket(productDetails: ProductDetails): Completable {
        return basketDatabase.removeFromBasket(productDetails)
    }

    override fun addToBasket(productDetails: ProductDetails): Completable {
        return basketDatabase.addToBasket(productDetails)
    }

    override fun basket(): Single<List<ProductDetails>> {
        return basketDatabase.getBasket()
    }

}