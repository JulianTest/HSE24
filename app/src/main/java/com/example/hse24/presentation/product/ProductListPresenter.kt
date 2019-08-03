package com.example.hse24.presentation.product

import com.example.hse24.core.usecases.safeDispose
import com.example.hse24.core.usecases.withSchedulers
import com.example.hse24.domain.GetProductListUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ProductListPresenter @Inject constructor(private val getProductListUseCase: GetProductListUseCase): ProductListContract.Presenter{

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }
    private lateinit var view: ProductListContract.View
    override fun onBind() {
        view.showLoading()
        disposable += getProductListUseCase.invoke(view.getCategoryId()).withSchedulers().subscribeBy(onSuccess = {
            view.showContent()
            view.showProductList(it)
        }, onError = {
            view.showError()
        })
    }

    override fun onUnbind() {
        disposable.safeDispose()
    }

    override fun setView(baseView: ProductListContract.View) {
        view = baseView
    }

}