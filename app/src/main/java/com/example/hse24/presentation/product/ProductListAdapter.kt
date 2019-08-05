package com.example.hse24.presentation.product

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hse24.domain.models.ProductInfo

class ProductListAdapter (private val productList: List<ProductInfo>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        const val LOADING = 1
        const val VIEW = 2
    }
    private var showLoading = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            LOADING-> LoadingViewHolder(parent)
            else -> ProductItemViewHolder(parent)}
    }

    override fun getItemCount(): Int {
        return if (showLoading)productList.size+1
        else productList.size
    }

    override fun getItemViewType(position: Int): Int {
       return if (position >= productList.size) return LOADING
        else VIEW
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      when(holder){
          is ProductItemViewHolder ->  holder.bindTo(productList[position])
      }
    }

    fun addProducts(it: List<ProductInfo>) {
        if (productList is ArrayList<ProductInfo>){
            showLoading = false
            productList.addAll(it)
            notifyDataSetChanged()
        }

    }

    fun showLoading() {
        showLoading = true
        notifyDataSetChanged()
    }

}