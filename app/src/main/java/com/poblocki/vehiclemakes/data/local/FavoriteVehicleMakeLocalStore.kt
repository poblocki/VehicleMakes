package com.poblocki.vehiclemakes.data.local

import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class FavoriteVehicleMakeLocalStore {

    private val localStore: BehaviorSubject<Set<VehicleMakeId>> =
        BehaviorSubject.createDefault(setOf())

    fun changeStateFor(id: VehicleMakeId): Completable = Completable.fromAction {
        val current = localStore.value?.toMutableSet() ?: mutableSetOf()
        if (current.contains(id)) {
            current.remove(id)
        } else {
            current.add(id)
        }
        localStore.onNext(current)
    }

    fun getAllFavoriteIds(): Flowable<Set<VehicleMakeId>> =
        localStore.toFlowable(BackpressureStrategy.LATEST)
}