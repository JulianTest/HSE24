package com.example.hse24.presentation.product

import com.example.hse24.core.usecases.withSchedulers
import com.example.hse24.domain.AddToBasketUseCase
import com.example.hse24.domain.GetProductDetailsUseCase
import com.example.hse24.domain.models.ProductDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ProductDetailsPresenter @Inject constructor(private val getProductDetailsUseCase: GetProductDetailsUseCase,
                                                  private val addToBasketUseCase: AddToBasketUseCase): ProductDetailsContract.Presenter{
    private var productDetails: ProductDetails? = null
    override fun addToBasket() {
        productDetails?.let {
            addToBasketUseCase.invoke(it).subscribeBy(onComplete = {
                view.showBasketSuccess()
            }, onError = {
                view.showBasketError()
            })
        }
    }

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    private lateinit var view: ProductDetailsContract.View
    override fun onBind() {
        //todo check if product is currently in basket
        disposable += getProductDetailsUseCase.invoke(view.getProductId()).withSchedulers().subscribeBy(onSuccess = {
            view.showContent()
            view.showProductDetails(it)
            productDetails = it
        }, onError = {
            view.showError()
        })
    }

    override fun onUnbind() {
        disposable.dispose()
    }

    override fun setView(baseView: ProductDetailsContract.View) {
        view = baseView
    }

}