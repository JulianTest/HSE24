package com.example.hse24.domain

import com.example.hse24.core.usecases.UseCase
import com.example.hse24.data.HseFromNetwork
import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Single
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val hseFromNetwork: HseFromNetwork
) : UseCase<ProductDetails, String>() {
    override fun buildUseCase(param: String): Single<ProductDetails> {
        return hseFromNetwork.productDetails(param).map {
            ProductDetails(
                it.sku,
                it.nameShort,
                createImageUrl(it.imageUris.first()),
                it.productPrice.price.toInt(),
                it.longDescription
            )
        }
    }

    private fun createImageUrl(id: String): String {
        return "https://pic.hse24-dach.net/media/de/products/" + id + "pics480.jpg"
    }
}
