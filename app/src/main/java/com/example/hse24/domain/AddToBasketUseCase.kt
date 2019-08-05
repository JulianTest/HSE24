package com.example.hse24.domain

import com.example.hse24.core.usecases.CompletableUseCase
import com.example.hse24.data.BasketRepository
import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import javax.inject.Inject

class AddToBasketUseCase @Inject constructor(private val basketRepository: BasketRepository): CompletableUseCase<ProductDetails>(){
    override fun buildUseCaseCompletable(param: ProductDetails): Completable {
       return basketRepository.addToBasket(param)
    }

}