package com.poblocki.vehiclemakes.common

import io.reactivex.rxjava3.core.Scheduler

interface AppSchedulers {
    val computation: Scheduler
    val dbIO: Scheduler
    val networkIO: Scheduler
    val mainThread: Scheduler
}