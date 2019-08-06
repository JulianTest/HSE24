package com.example.hse24.core.di

import android.content.Context
import com.example.hse24.core.HseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule(private val hseApplication: HseApplication) {
    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return hseApplication.applicationContext
    }

    @Provides
    @Singleton
    internal fun provideHseApp(): HseApplication {
        return hseApplication
    }

}