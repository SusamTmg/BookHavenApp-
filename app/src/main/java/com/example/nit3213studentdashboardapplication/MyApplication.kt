package com.example.nit3213studentdashboardapplication

import android.app.Application
import com.example.nit3213studentdashboardapplication.di.appModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}
