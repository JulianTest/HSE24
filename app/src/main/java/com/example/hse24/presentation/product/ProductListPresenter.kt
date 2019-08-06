package com.example.hse24.presentation.product

import com.example.hse24.core.usecases.safeDispose
import com.example.hse24.core.usecases.withSchedulers
import com.example.hse24.domain.GetProductListUseCase
import com.example.hse24.domain.ProductListParams
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ProductListPresenter @Inject constructor(private val getProductListUseCase: GetProductListUseCase) :
    ProductListContract.Presenter {

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }
    private lateinit var view: ProductListContract.View
    private var currentPage = 1
    override fun onBind() {
        view.showLoading()
        disposable += getProductListUseCase.invoke(ProductListParams(view.getCategoryId(), currentPage))
            .withSchedulers().subscribeBy(onSuccess = {
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

    override fun loadMore() {
        getProductListUseCase.invoke(ProductListParams(view.getCategoryId(), currentPage + 1)).withSchedulers()
            .subscribeBy(onSuccess = {
                view.addProducts(it)
                currentPage++
            }, onError = {
                //todo custom error so user can go on
            })
    }

}