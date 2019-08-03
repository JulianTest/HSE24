package com.example.hse24.presentation.product

import com.example.hse24.core.mvp.BasePresenter
import com.example.hse24.core.mvp.BaseView
import com.example.hse24.domain.models.ProductInfo

interface ProductListContract{
    interface View: BaseView{
        fun getCategoryId(): Int
        fun showProductList(it: List<ProductInfo>)

    }
    interface Presenter: BasePresenter<View>{

    }
}