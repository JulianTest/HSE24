package com.example.hse24.presentation.basket

import com.example.hse24.core.mvp.BasePresenter
import com.example.hse24.core.mvp.BaseView
import com.example.hse24.domain.models.ProductDetails

interface BasketContract{
    interface View: BaseView {
        fun showProducts(products: List<ProductDetails>)
    }
    interface Presenter: BasePresenter<View> {

    }
}