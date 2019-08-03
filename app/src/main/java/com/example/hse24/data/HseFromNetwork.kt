package com.example.hse24.data

import com.example.hse24.data.models.CategoryResultDto
import com.example.hse24.data.models.ProductListDto
import io.reactivex.Single
import javax.inject.Inject

class HseFromNetwork @Inject constructor(
    private val hseApi: HseApi
) : HseFromNetworkDataSource {
    override fun productList(categoryId: Int): Single<ProductListDto> {
        return hseApi.productList(categoryId)
    }

    override fun categoryTree(): Single<CategoryResultDto> {
        return hseApi.categoryTree()
    }


}