package com.poblocki.vehiclemakes.common

import com.poblocki.memorycompose.common.AppSchedulersImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.dsl.module

val commonModule = module {
    single { provideAppSchedulers() }
}

fun provideAppSchedulers(): AppSchedulers =
    AppSchedulersImpl(
        computation = Schedulers.computation(),
        dbIO = Schedulers.single(),
        networkIO = Schedulers.io(),
        mainThread = AndroidSchedulers.mainThread()
    )