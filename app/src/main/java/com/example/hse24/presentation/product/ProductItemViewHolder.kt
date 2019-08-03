package com.example.hse24.presentation.product

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hse24.R
import com.example.hse24.core.inflate
import com.example.hse24.domain.models.ProductInfo
import kotlinx.android.synthetic.main.product_item_view.view.*

class ProductItemViewHolder(val parent: ViewGroup): RecyclerView.ViewHolder(parent.inflate(R.layout.product_item_view)) {
    fun bindTo(productInfo: ProductInfo) {
        with(itemView){
            Glide.with(context).load(productInfo.imageUrl).into(image)
            name.text = productInfo.name
            price.text = ""+productInfo.price
        }
    }
}