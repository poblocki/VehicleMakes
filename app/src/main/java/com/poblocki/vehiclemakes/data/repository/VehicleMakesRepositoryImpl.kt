package com.poblocki.vehiclemakes.data.repository

import com.poblocki.vehiclemakes.data.api.FakeAPIService
import com.poblocki.vehiclemakes.domain.model.VehicleMake
import com.poblocki.vehiclemakes.domain.repository.VehicleMakesRepository
import io.reactivex.rxjava3.core.Flowable

class VehicleMakesRepositoryImpl(private val externalService: FakeAPIService) :
    VehicleMakesRepository {

    override fun getVehicleMakes(): Flowable<List<VehicleMake>> = externalService.getVehicleMakes()
}