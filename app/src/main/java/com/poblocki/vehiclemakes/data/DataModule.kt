package com.poblocki.vehiclemakes.data

import com.poblocki.vehiclemakes.data.api.FakeAPIService
import com.poblocki.vehiclemakes.data.local.FavoriteVehicleMakeLocalStore
import com.poblocki.vehiclemakes.data.repository.FavoriteMakesRepositoryImpl
import com.poblocki.vehiclemakes.data.repository.VehicleMakesRepositoryImpl
import com.poblocki.vehiclemakes.domain.repository.FavoriteMakesRepository
import com.poblocki.vehiclemakes.domain.repository.VehicleMakesRepository
import org.koin.dsl.module

val dataModule = module {
    single<FavoriteMakesRepository> { FavoriteMakesRepositoryImpl(get()) }
    single<VehicleMakesRepository> { VehicleMakesRepositoryImpl(get()) }

    single { FavoriteVehicleMakeLocalStore() }
    factory { FakeAPIService() }
}