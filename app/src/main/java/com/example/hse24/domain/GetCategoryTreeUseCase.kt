package com.example.hse24.domain

import com.example.hse24.core.usecases.UseCase
import com.example.hse24.data.HseFromNetwork
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class GetCategoryTreeUseCase @Inject constructor(
    private val hseFromNetwork: HseFromNetwork
) : UseCase<Response<Any>, Unit>() {
    override fun buildUseCase(param: Unit): Single<Response<Any>> {
        return hseFromNetwork.categoryTree()
    }

}