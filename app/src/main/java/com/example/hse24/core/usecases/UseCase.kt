package com.example.hse24.core.usecases

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


abstract class UseCase<T, in Params> {

    private var disposables: CompositeDisposable? = null

    fun dispose() = disposables.safeDispose()

    abstract fun buildUseCase(param: Params): Single<T>

    operator fun invoke(param: Params): Single<T> = buildUseCase(param)

    operator fun invoke(observer: DisposableSingleObserver<T>, param: Params) {
        dispose()
        val single = buildUseCase(param).withSchedulers()
        disposables = CompositeDisposable().apply { add(single.subscribeWith(observer)) }
    }
}

fun Disposable?.safeDispose() = this?.takeUnless { isDisposed }?.dispose()
fun <T> Single<out T>.withSchedulers(): Single<out T> =
    this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

operator fun <T> UseCase<T, Unit>.invoke(): Single<T> = this(Unit)
