package com.example.mvvm.presentation

import android.app.Application
import com.example.mvvm.presentation.di.moduleFilms
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Koin Android logger
            androidLogger(Level.ERROR)
            //inject Android context
            androidContext(this@App)

            modules(moduleFilms)


        }

    }

}