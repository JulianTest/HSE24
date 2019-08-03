package com.example.hse24.presentation.categories

import com.example.hse24.core.mvp.BasePresenter
import com.example.hse24.core.mvp.BaseView

interface CategoryContract{
    interface View: BaseView{

    }
    interface Presenter: BasePresenter<View>{

    }
}