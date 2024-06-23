package com.css101.airtickets.app

import android.app.Application
import com.css101.airtickets.di.appModule
import com.css101.airtickets.di.dataModule
import com.css101.airtickets.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}