package com.example.hse24.data

import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class HseFromNetwork @Inject constructor(
    private val hseApi: HseApi
) : HseFromNetworkDataSource {
    override fun categoryTree(): Single<Response<Any>> {
        return hseApi.categoryTree()
    }


}