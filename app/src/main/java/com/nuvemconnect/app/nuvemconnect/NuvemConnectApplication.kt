package com.nuvemconnect.app.nuvemconnect

import android.app.Application
import com.nuvemconnect.app.nuvemconnect.di.modules.authModule
import com.nuvemconnect.app.nuvemconnect.di.modules.authUseCaseModule
import com.nuvemconnect.app.nuvemconnect.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NuvemConnectApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@NuvemConnectApplication)
            modules(viewModelModule, authModule, authUseCaseModule)
        }
    }
}
