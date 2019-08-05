package com.example.hse24.data

import com.example.hse24.data.models.CategoryResultDto
import com.example.hse24.data.models.ProductDetailsDto
import com.example.hse24.data.models.ProductListDto
import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class HseFromNetwork @Inject constructor(
    private val hseApi: HseApi
) : HseFromNetworkDataSource {
    override fun productDetails(productId: String): Single<ProductDetailsDto> {
        return hseApi.productDetails(productId)
    }

    override fun productList(categoryId: Int, page: Int): Single<ProductListDto> {
        return hseApi.productList(categoryId, page)
    }

    override fun categoryTree(): Single<CategoryResultDto> {
        return hseApi.categoryTree()
    }

    override fun addToBasket(productDetails: ProductDetails): Completable {
        return hseApi.addToBasket()
    }

    override fun basket(): Single<List<ProductDetails>> {
        return hseApi.getBasket()
    }

    override fun deleteFromBasket(productDetails: ProductDetails): Completable {
        return hseApi.deleteFromBasket()
    }
}