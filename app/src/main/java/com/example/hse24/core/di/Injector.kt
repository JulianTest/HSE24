package com.example.hse24.core.di

import com.example.hse24.core.HseApplication

object Injector{
    private var appComponentImpl: ApplicationComponent? = null


    @JvmStatic
    val appComponent: ApplicationComponent
        get() = requireNotNull(appComponentImpl)

    fun init(application: HseApplication) {
        if (appComponentImpl == null) {
            appComponentImpl = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(application))
                .build()
        }
    }
}