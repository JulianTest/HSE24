package com.example.hse24.presentation.categories

import com.example.hse24.core.mvp.BasePresenter
import com.example.hse24.core.mvp.BaseView
import com.example.hse24.domain.models.SimpleCategory

interface CategoryContract{
    interface View: BaseView{
        fun showCategories(categories: List<SimpleCategory>)
    }
    interface Presenter: BasePresenter<View>{

    }
}