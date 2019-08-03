package com.example.hse24.data

import com.example.hse24.data.models.CategoryResultDto
import com.example.hse24.data.models.ProductListDto
import io.reactivex.Single
import retrofit2.http.*

interface HseApi{


    @Headers("appDevice: ANDROID_PHONE","locale: de_DE")
    @GET("category/tree")
    fun categoryTree(): Single<CategoryResultDto>

    @Headers("appDevice: ANDROID_PHONE","locale: de_DE")
    @GET("https://www.hse24.de/ext-api/app/1/c/**/*-{categoryId}/%3Fpage%3D2{page}")
    fun productList(@Path("categoryId") categoryId:Int, @Path("page")page: Int = 1): Single<ProductListDto>
}