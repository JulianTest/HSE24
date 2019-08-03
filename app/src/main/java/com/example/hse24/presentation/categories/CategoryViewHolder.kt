package com.example.hse24.presentation.categories

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hse24.R
import com.example.hse24.core.activityContext
import com.example.hse24.core.inflate
import com.example.hse24.domain.models.SimpleCategory
import com.example.hse24.presentation.navigateToProductList
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
    parent.inflate(R.layout.category_item)
){

    fun bindTo(category: SimpleCategory){
        with(itemView){
            categoryTextView.text = category.displayName
            itemView.setOnClickListener {
                activityContext.navigateToProductList(categoryId = category.categoryId)
            }
        }
    }
}
