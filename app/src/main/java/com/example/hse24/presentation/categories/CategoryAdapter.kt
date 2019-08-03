package com.example.hse24.presentation.categories

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hse24.domain.models.SimpleCategory

class CategoryAdapter (private val categories: List<SimpleCategory>): RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindTo(categories[position])
    }
}