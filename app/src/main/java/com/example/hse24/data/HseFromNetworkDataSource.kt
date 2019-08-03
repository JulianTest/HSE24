package com.example.hse24.data

import com.example.hse24.data.models.CategoryResultDto
import com.example.hse24.data.models.ProductListDto
import io.reactivex.Single

interface HseFromNetworkDataSource{
  fun  categoryTree(): Single<CategoryResultDto>
  fun  productList(categoryId: Int): Single<ProductListDto>
}