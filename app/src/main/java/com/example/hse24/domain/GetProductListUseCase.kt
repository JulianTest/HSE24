package com.example.hse24.domain

import com.example.hse24.core.usecases.UseCase
import com.example.hse24.data.HseFromNetwork
import com.example.hse24.domain.models.ProductInfo
import io.reactivex.Single
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(  private val hseFromNetwork: HseFromNetwork
) : UseCase<List<ProductInfo>, Int>() {
    override fun buildUseCase(param: Int): Single<List<ProductInfo>> {
       return hseFromNetwork.productList(param).map {
           val list =  ArrayList<ProductInfo>()
             for(product in it.productResults){
                 list.add(ProductInfo(id = product.sku,
                     price = product.productPrice.price.toInt(),
                     name = product.nameShort,
                     imageUrl = createImageUrl(product.imageUris.first())))
             }
           return@map list
        }
    }

    private fun createImageUrl(id: String): String{
        return "https://pic.hse24-dach.net/media/de/products/"+id+"pics480.jpg"
    }
}