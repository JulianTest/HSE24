package com.example.hse24.core.di

import com.example.hse24.presentation.MainActivity
import com.example.hse24.presentation.basket.BasketActivity
import com.example.hse24.presentation.product.ProductDetailsActivity
import com.example.hse24.presentation.product.ProductListActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        (ApplicationModule::class),
        (NetworkModule::class),
        (HseModule::class)
    ]
)
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(productListActivity: ProductListActivity)
    fun inject(productDetailsActivity: ProductDetailsActivity)
    fun inject(basketActivity: BasketActivity)
}