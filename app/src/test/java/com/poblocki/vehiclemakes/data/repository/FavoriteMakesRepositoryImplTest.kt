package com.poblocki.vehiclemakes.data.repository

import com.poblocki.vehiclemakes.data.local.FavoriteVehicleMakeLocalStore
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Flowable
import org.junit.Test

class FavoriteMakesRepositoryImplTest {

    private val favoriteVehicleMakeLocalStore: FavoriteVehicleMakeLocalStore = mockk()
    private val systemUnderTest = FavoriteMakesRepositoryImpl(favoriteVehicleMakeLocalStore)

    @Test
    fun getAllFavoritesIds() {
        every { favoriteVehicleMakeLocalStore.getAllFavoriteIds() } returns Flowable.just(
            setOf(
                VehicleMakeId("1"),
                VehicleMakeId("2")
            )
        )

        systemUnderTest.getAllFavoritesIds()
            .test()
            .assertValue(
                setOf(
                    VehicleMakeId("1"),
                    VehicleMakeId("2")
                )
            )

        verify { favoriteVehicleMakeLocalStore.getAllFavoriteIds() }
    }
}