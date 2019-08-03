package com.example.hse24.core.di

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        (ApplicationModule::class),
        (NetworkModule::class)
    ]
)
interface ApplicationComponent