package com.nuvemconnect.app.nuvemconnect

import android.app.Application
import com.nuvemconnect.app.nuvemconnect.di.modules.authModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class NuvemConnectApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@NuvemConnectApplication)
            modules(authModule)
        }
    }
}