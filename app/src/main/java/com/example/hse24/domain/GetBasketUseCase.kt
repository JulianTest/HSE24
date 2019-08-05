package com.example.hse24.domain

import com.example.hse24.core.usecases.UseCase
import com.example.hse24.data.BasketRepository
import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Single
import javax.inject.Inject

class GetBasketUseCase @Inject constructor(private val basketRepository: BasketRepository): UseCase<List<ProductDetails>, Unit>(){
    override fun buildUseCase(param: Unit): Single<List<ProductDetails>> {
        return basketRepository.getBasket()
    }
}