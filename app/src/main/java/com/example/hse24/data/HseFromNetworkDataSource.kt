package com.example.hse24.data

import com.example.hse24.data.models.CategoryResultDto
import com.example.hse24.data.models.ProductDetailsDto
import com.example.hse24.data.models.ProductListDto
import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import io.reactivex.Single

interface HseFromNetworkDataSource{
  fun categoryTree(): Single<CategoryResultDto>
  fun productList(categoryId: Int, page: Int = 1): Single<ProductListDto>
  fun productDetails(productId:String): Single<ProductDetailsDto>
  fun addToBasket(productDetails: ProductDetails): Completable
  fun basket(): Single<List<ProductDetails>>
  fun deleteFromBasket(productDetails: ProductDetails): Completable
}