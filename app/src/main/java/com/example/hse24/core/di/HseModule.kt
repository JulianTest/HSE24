package com.example.hse24.core.di

import com.example.hse24.data.HseApi
import com.example.hse24.data.HseFromNetwork
import com.example.hse24.data.HseFromNetworkDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class HseModule{

    @Provides
    internal fun provideConfigApi(retrofit: Retrofit): HseApi {
        return retrofit.create(HseApi::class.java)
    }

    @Provides
    internal fun provideHseFromNetwork(hseFromNetwork: HseFromNetwork): HseFromNetworkDataSource {
        return hseFromNetwork
    }

}