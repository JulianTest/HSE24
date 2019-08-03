package com.example.hse24.core.di

import com.example.hse24.presentation.MainActivity
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
}