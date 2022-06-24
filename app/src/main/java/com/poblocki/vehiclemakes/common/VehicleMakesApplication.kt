package com.poblocki.vehiclemakes.common

import android.app.Application
import com.poblocki.vehiclemakes.data.dataModule
import com.poblocki.vehiclemakes.domain.domainModule
import com.poblocki.vehiclemakes.presentation.common.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class VehicleMakesApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@VehicleMakesApplication)
            androidLogger(Level.ERROR)
            modules(
                commonModule
                    .plus(dataModule)
                    .plus(domainModule)
                    .plus(presentationModule)
            )
        }
    }
}