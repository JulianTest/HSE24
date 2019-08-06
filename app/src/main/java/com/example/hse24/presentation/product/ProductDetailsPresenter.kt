package com.example.hse24.presentation.product

import com.example.hse24.core.usecases.invoke
import com.example.hse24.core.usecases.withSchedulers
import com.example.hse24.domain.AddToBasketUseCase
import com.example.hse24.domain.GetBasketUseCase
import com.example.hse24.domain.GetProductDetailsUseCase
import com.example.hse24.domain.RemoveFromBasketUseCase
import com.example.hse24.domain.models.ProductDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Singles
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ProductDetailsPresenter @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase,
    private val addToBasketUseCase: AddToBasketUseCase,
    private val removeFromBasketUseCase: RemoveFromBasketUseCase,
    private val getBasketUseCase: GetBasketUseCase
) : ProductDetailsContract.Presenter {
    private var productDetails: ProductDetails? = null
    private var inBasket = false
    override fun basketButtonClicked() {
        if (inBasket) {
            productDetails?.let {
                removeFromBasketUseCase.invoke(it).subscribeBy(onComplete = {
                    inBasket = false
                    view.showBasketSuccess(false)
                    view.setBasket(true)
                }, onError = {
                    view.showBasketError()
                })
            }
        } else {
            productDetails?.let {
                addToBasketUseCase.invoke(it).subscribeBy(onComplete = {
                    inBasket = true
                    view.showBasketSuccess(true)
                    view.setBasket(false)
                }, onError = {
                    view.showBasketError()
                })
            }
        }
    }

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }

    private lateinit var view: ProductDetailsContract.View
    override fun onBind() {
        disposable += Singles.zip(getProductDetailsUseCase.invoke(view.getProductId()), getBasketUseCase.invoke())
            .withSchedulers().subscribeBy(onSuccess = {
                view.showContent()
                if (it.second.contains(it.first)) {
                    inBasket = true
                    view.setBasket(false)
                }
                view.showProductDetails(it.first)
                productDetails = it.first
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