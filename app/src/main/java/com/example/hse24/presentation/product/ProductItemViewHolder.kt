package com.example.hse24.presentation.product

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hse24.R
import com.example.hse24.core.activityContext
import com.example.hse24.core.inflate
import com.example.hse24.domain.models.ProductInfo
import com.example.hse24.presentation.navigateToProductDetails
import kotlinx.android.synthetic.main.product_item_view.view.*

class ProductItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.product_item_view)) {
    fun bindTo(productInfo: ProductInfo) {
        with(itemView) {
            Glide.with(context).load(productInfo.imageUrl).into(image)
            name.text = productInfo.name
            price.text = "" + productInfo.price + "Euro"
            itemView.setOnClickListener {
                activityContext.navigateToProductDetails(productInfo.id)
            }
        }

    }
}