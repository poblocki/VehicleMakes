package com.poblocki.vehiclemakes.data.local

import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import org.junit.Test

class FavoriteVehicleMakeLocalStoreTest {

    private val systemUnderTest = FavoriteVehicleMakeLocalStore()

    @Test
    fun getAllFavoriteIds() {
        systemUnderTest.getAllFavoriteIds()
            .test()
            .assertValue(emptySet())

        systemUnderTest.changeStateFor(VehicleMakeId("id"))
            .test()
            .assertComplete()

        systemUnderTest.getAllFavoriteIds()
            .test()
            .assertValue(setOf(VehicleMakeId("id")))
    }
}