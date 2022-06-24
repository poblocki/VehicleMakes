package com.poblocki.vehiclemakes.domain.repository

import com.poblocki.vehiclemakes.domain.model.VehicleMake
import io.reactivex.rxjava3.core.Flowable

interface VehicleMakesRepository {

    fun getVehicleMakes(): Flowable<List<VehicleMake>>
}