package com.example.hse24.data

import io.reactivex.Single
import retrofit2.Response

interface HseFromNetworkDataSource{
  fun  categoryTree(): Single<Response<Any>>
}