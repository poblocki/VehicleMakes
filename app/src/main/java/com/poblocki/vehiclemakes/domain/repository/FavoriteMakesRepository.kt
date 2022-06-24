package com.poblocki.vehiclemakes.domain.repository

import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface FavoriteMakesRepository {

    fun changeStateFor(id: VehicleMakeId): Completable
    fun getAllFavoritesIds(): Flowable<Set<VehicleMakeId>>
}