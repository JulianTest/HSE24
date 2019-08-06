package com.example.hse24.presentation.categories

import com.example.hse24.core.usecases.invoke
import com.example.hse24.core.usecases.safeDispose
import com.example.hse24.core.usecases.withSchedulers
import com.example.hse24.domain.GetCategoryTreeUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CategoryPresenter @Inject constructor(private val categoryTreeUseCase: GetCategoryTreeUseCase) :
    CategoryContract.Presenter {

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }
    private lateinit var view: CategoryContract.View
    override fun onBind() {
        view.showLoading()
        disposable += categoryTreeUseCase.invoke().withSchedulers().subscribeBy(onError = {
            view.showError()
        },
            onSuccess = {
                view.showContent()
                view.showCategories(it)
            })
    }

    override fun onUnbind() {
        disposable.safeDispose()
    }

    override fun setView(baseView: CategoryContract.View) {
        view = baseView
    }


}