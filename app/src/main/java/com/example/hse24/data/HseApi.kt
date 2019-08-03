package com.example.hse24.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface HseApi{


    @Headers("appDevice: ANDROID_PHONE","locale: de_DE")
    @GET("category/tree")
    fun categoryTree(): Single<Response<Any>>
}