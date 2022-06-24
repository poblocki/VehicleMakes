package com.poblocki.vehiclemakes.domain.usecase

import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import com.poblocki.vehiclemakes.domain.repository.FavoriteMakesRepository
import io.reactivex.rxjava3.core.Completable

class ChangeVehicleAsFavoriteUseCase(private val favoriteMakesRepository: FavoriteMakesRepository) {

    fun changeStateFor(id: VehicleMakeId): Completable =
        favoriteMakesRepository.changeStateFor(id)
}