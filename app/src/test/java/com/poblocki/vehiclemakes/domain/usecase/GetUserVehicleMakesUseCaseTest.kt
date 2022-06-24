package com.poblocki.vehiclemakes.domain.usecase

import com.poblocki.vehiclemakes.domain.model.UserVehicleMake
import com.poblocki.vehiclemakes.domain.model.VehicleMake
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import com.poblocki.vehiclemakes.domain.repository.FavoriteMakesRepository
import com.poblocki.vehiclemakes.domain.repository.VehicleMakesRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Flowable
import org.junit.Test

class GetUserVehicleMakesUseCaseTest {

    private val vehicleMakesRepository: VehicleMakesRepository = mockk()
    private val favoriteMakesRepository: FavoriteMakesRepository = mockk()
    private val systemUnderTest =
        GetUserVehicleMakesUseCase(vehicleMakesRepository, favoriteMakesRepository)

    @Test
    fun getUserVehicles() {
        every { vehicleMakesRepository.getVehicleMakes() } returns Flowable.just(
            listOf(
                VehicleMake(
                    id = VehicleMakeId("AUD"),
                    name = "Audi"
                ),
                VehicleMake(
                    id = VehicleMakeId("MER"),
                    name = "Mercedes"
                ),
                VehicleMake(
                    id = VehicleMakeId("TES"),
                    name = "Tesla"
                )
            )
        )
        every { favoriteMakesRepository.getAllFavoritesIds() } returns Flowable.just(
            setOf(
                VehicleMakeId("MER")
            )
        )

        val expected = listOf(
            UserVehicleMake(
                vehicleMake = VehicleMake(
                    id = VehicleMakeId("AUD"),
                    name = "Audi"
                ),
                isFavorite = false
            ),
            UserVehicleMake(
                vehicleMake = VehicleMake(
                    id = VehicleMakeId("MER"),
                    name = "Mercedes"
                ),
                isFavorite = true
            ),
            UserVehicleMake(
                vehicleMake = VehicleMake(
                    id = VehicleMakeId("TES"),
                    name = "Tesla"
                ),
                isFavorite = false
            )
        )

        systemUnderTest.getUserVehicles()
            .test()
            .assertValue(expected)

        verify {
            vehicleMakesRepository.getVehicleMakes()
            favoriteMakesRepository.getAllFavoritesIds()
        }
    }
}