package com.example.hse24.presentation.product

import com.example.hse24.core.mvp.BasePresenter
import com.example.hse24.core.mvp.BaseView
import com.example.hse24.domain.models.ProductDetails

interface ProductDetailsContract {
    interface View : BaseView {
        fun getProductId(): String
        fun showProductDetails(productDetails: ProductDetails)
        fun showBasketSuccess(inBasket: Boolean)
        fun showBasketError()
        fun setBasket(enabled: Boolean)

    }

    interface Presenter : BasePresenter<View> {
        fun basketButtonClicked()
    }
}