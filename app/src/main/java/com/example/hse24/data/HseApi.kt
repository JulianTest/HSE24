package com.example.hse24.data

import com.example.hse24.data.models.CategoryResultDto
import com.example.hse24.data.models.ProductDetailsDto
import com.example.hse24.data.models.ProductListDto
import com.example.hse24.domain.models.ProductDetails
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface HseApi{


    @Headers("appDevice: ANDROID_PHONE","locale: de_DE")
    @GET("category/tree")
    fun categoryTree(): Single<CategoryResultDto>

    @Headers("appDevice: ANDROID_PHONE","locale: de_DE")
    @GET("c/**/*-{categoryId}/%3Fpage%3D2{page}")
    fun productList(@Path("categoryId") categoryId:Int, @Path("page")page: Int = 1): Single<ProductListDto>


    @Headers("appDevice: ANDROID_PHONE","locale: de_DE")
    @GET("product/{productId}")
    fun productDetails(@Path("productId") productId:String): Single<ProductDetailsDto>

    //todo create backend and actual logic
    fun addToBasket(): Completable
    fun getBasket(): Single<List<ProductDetails>>
    fun deleteFromBasket(): Completable

}