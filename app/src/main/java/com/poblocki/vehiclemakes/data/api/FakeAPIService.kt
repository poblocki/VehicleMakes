package com.poblocki.vehiclemakes.data.api

import com.poblocki.vehiclemakes.domain.model.VehicleMake
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import io.reactivex.rxjava3.core.Flowable

class FakeAPIService {

    fun getVehicleMakes(): Flowable<List<VehicleMake>> = Flowable.just(
        listOf(
            VehicleMake(VehicleMakeId("AUD"), "Audi"),
            VehicleMake(VehicleMakeId("BMW"), "BMW"),
            VehicleMake(VehicleMakeId("CIT"), "Citroen"),
            VehicleMake(VehicleMakeId("FIA"), "Fiat"),
            VehicleMake(VehicleMakeId("FOR"), "Ford"),
            VehicleMake(VehicleMakeId("MER"), "Mercedes"),
            VehicleMake(VehicleMakeId("REN"), "Renault"),
            VehicleMake(VehicleMakeId("PEU"), "Peugeot"),
            VehicleMake(VehicleMakeId("SEA"), "Seat"),
            VehicleMake(VehicleMakeId("TES"), "Tesla"),
            VehicleMake(VehicleMakeId("TOY"), "Toyota"),
            VehicleMake(VehicleMakeId("VOL"), "Volkswagen")
        )
    )
}