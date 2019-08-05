package com.example.hse24.data

import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(private val hseFromNetwork: HseFromNetwork,
                                               private val basketFromLocal: BasketFromLocal): BasketRepository{
    override fun addToBasket(productDetails: ProductDetails): Completable {

        return if (isLoggedIn()){
            //logged in User Basket is synced over backend
            hseFromNetwork.addToBasket(productDetails)
        } else basketFromLocal.addToBasket(productDetails)
    }

    override fun getBasket(): Single<List<ProductDetails>> {
       return if (isLoggedIn()) hseFromNetwork.basket()
        else basketFromLocal.basket()
    }

    override fun removeFromBasket(productDetails: ProductDetails): Completable {
        return if (isLoggedIn())hseFromNetwork.deleteFromBasket(productDetails)
        else basketFromLocal.deleteFromBasket(productDetails)
    }

    fun isLoggedIn():Boolean{
         return false
    }
}