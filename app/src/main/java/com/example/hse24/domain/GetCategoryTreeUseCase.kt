package com.example.hse24.domain

import com.example.hse24.core.usecases.UseCase
import com.example.hse24.data.HseFromNetwork
import com.example.hse24.data.models.CategoryDto
import com.example.hse24.domain.models.SimpleCategory
import com.example.hse24.domain.models.toSimpleList
import io.reactivex.Single
import javax.inject.Inject

class GetCategoryTreeUseCase @Inject constructor(
    private val hseFromNetwork: HseFromNetwork
) : UseCase<List<SimpleCategory>, Unit>() {
    override fun buildUseCase(param: Unit): Single<List<SimpleCategory>> {
        return hseFromNetwork.categoryTree().map {
            val list = ArrayList<SimpleCategory>()
            for (category in it.children){
                list.add(category.toSimpleList())
                addAll(list, category)
            }
            return@map list
        }
    }

    //generate a simple List, so no complex category navigation is needed
    //bad UX but all functionality exists
    private fun addAll(list: ArrayList<SimpleCategory>, parent: CategoryDto){
        for (category in parent.children){
            list.add(category.toSimpleList())
            addAll(list, category)
        }    }
}