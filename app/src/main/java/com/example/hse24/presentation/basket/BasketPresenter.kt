package com.example.hse24.presentation.basket

import com.example.hse24.core.usecases.invoke
import com.example.hse24.core.usecases.safeDispose
import com.example.hse24.core.usecases.withSchedulers
import com.example.hse24.domain.GetBasketUseCase
import com.example.hse24.domain.RemoveFromBasketUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class BasketPresenter @Inject constructor(private val removeFromBasketUseCase: RemoveFromBasketUseCase,
                                          private val getBasketUseCase: GetBasketUseCase): BasketContract.Presenter{

    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }
    private lateinit var view: BasketContract.View
    override fun onBind() {
       disposable += getBasketUseCase.invoke().withSchedulers().subscribeBy(onSuccess = {
            view.showContent()
            view.showProducts(it)
        }, onError = {
            view.showError()
        })
    }

    override fun onUnbind() {
        disposable.safeDispose()
    }

    override fun setView(baseView: BasketContract.View) {
        view = baseView
    }

}