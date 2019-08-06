package com.example.hse24.core.di

import com.example.hse24.data.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class HseModule {

    @Provides
    internal fun provideConfigApi(retrofit: Retrofit): HseApi {
        return retrofit.create(HseApi::class.java)
    }

    @Provides
    internal fun provideHseFromNetwork(hseFromNetwork: HseFromNetwork): HseFromNetworkDataSource {
        return hseFromNetwork
    }

    @Provides
    @Singleton
    internal fun provideBasket() = BasketDatabase()

    @Provides
    @Singleton
    internal fun provideBaskteRepository(basketRepositoryImpl: BasketRepositoryImpl): BasketRepository =
        basketRepositoryImpl


}