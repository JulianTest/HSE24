package com.example.hse24.core

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


abstract class EndlessScrollListener constructor(private val layoutManager: LinearLayoutManager) :
    RecyclerView.OnScrollListener() {
    private var loading = true
    private var previousTotalItemCount = 0

    abstract fun onLoadMore(totalItemsCount: Int)

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        val totalItemCount = layoutManager.itemCount

        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        if (!loading && lastVisibleItemPosition + VISIBLE_THRESHOLD > totalItemCount) {
            onLoadMore(totalItemCount)
            loading = true
        }
    }

    fun reset() {
        loading = false
        previousTotalItemCount = 0
    }

    companion object {
        private val VISIBLE_THRESHOLD = 4
    }
}