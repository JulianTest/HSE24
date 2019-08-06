package com.example.hse24.core

import android.app.Application
import com.example.hse24.core.di.Injector

class HseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }
}