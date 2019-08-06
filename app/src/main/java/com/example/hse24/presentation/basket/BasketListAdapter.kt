package com.example.hse24.presentation.basket

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hse24.domain.models.ProductDetails

class BasketListAdapter(private val productList: List<ProductDetails>) : RecyclerView.Adapter<BasketItemViewHolder>() {

    //todo add swipe to delete or edit mode
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketItemViewHolder {
        return BasketItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: BasketItemViewHolder, position: Int) {
        holder.bindTo(productList[position])
    }

}