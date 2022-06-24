package com.poblocki.vehiclemakes.data.repository

import com.poblocki.vehiclemakes.data.local.FavoriteVehicleMakeLocalStore
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import com.poblocki.vehiclemakes.domain.repository.FavoriteMakesRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

class FavoriteMakesRepositoryImpl(private val favoriteVehicleMakeLocalStore: FavoriteVehicleMakeLocalStore) :
    FavoriteMakesRepository {

    override fun changeStateFor(id: VehicleMakeId): Completable =
        favoriteVehicleMakeLocalStore.changeStateFor(id)

    override fun getAllFavoritesIds(): Flowable<Set<VehicleMakeId>> =
        favoriteVehicleMakeLocalStore.getAllFavoriteIds()
}