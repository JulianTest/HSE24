package com.example.hse24.presentation.product

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hse24.domain.models.ProductInfo

class ProductListAdapter (private val productList: List<ProductInfo>): RecyclerView.Adapter<ProductItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
       return ProductItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        holder.bindTo(productList[position])
    }

}