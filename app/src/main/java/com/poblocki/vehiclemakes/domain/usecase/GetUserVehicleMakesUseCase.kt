package com.poblocki.vehiclemakes.domain.usecase

import com.poblocki.vehiclemakes.domain.model.UserVehicleMake
import com.poblocki.vehiclemakes.domain.model.VehicleMake
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import com.poblocki.vehiclemakes.domain.repository.FavoriteMakesRepository
import com.poblocki.vehiclemakes.domain.repository.VehicleMakesRepository
import io.reactivex.rxjava3.core.Flowable

class GetUserVehicleMakesUseCase(
    private val vehicleMakesRepository: VehicleMakesRepository,
    private val favoriteMakesRepository: FavoriteMakesRepository
) {

    fun getUserVehicles(): Flowable<List<UserVehicleMake>> =
        Flowable.combineLatest(
            vehicleMakesRepository.getVehicleMakes(),
            favoriteMakesRepository.getAllFavoritesIds(),
            ::combineData
        )

    private fun combineData(
        allMakes: List<VehicleMake>,
        favoriteIds: Set<VehicleMakeId>
    ): List<UserVehicleMake> =
        allMakes.map { vehicleMake ->
            UserVehicleMake(
                vehicleMake = vehicleMake,
                isFavorite = favoriteIds.contains(vehicleMake.id)
            )
        }
}