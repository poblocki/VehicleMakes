package com.poblocki.memorycompose.common

import com.poblocki.vehiclemakes.common.AppSchedulers
import io.reactivex.rxjava3.core.Scheduler

class AppSchedulersImpl(
    override val computation: Scheduler,
    override val dbIO: Scheduler,
    override val networkIO: Scheduler,
    override val mainThread: Scheduler
) : AppSchedulers