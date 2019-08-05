package com.example.hse24.core.usecases

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<in Params> {

    private var disposables: CompositeDisposable? = null

    fun dispose() = disposables.safeDispose()

    abstract fun buildUseCaseCompletable(param: Params): Completable

    operator fun invoke(param: Params): Completable = buildUseCaseCompletable(param)

    operator fun invoke(observer: DisposableCompletableObserver, param: Params) {
        dispose()
        val completable = buildUseCaseCompletable(param).withSchedulers()
        disposables = CompositeDisposable().apply { add(completable.subscribeWith(observer)) }
    }

    fun  Completable.withSchedulers(): Completable =
        this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

}