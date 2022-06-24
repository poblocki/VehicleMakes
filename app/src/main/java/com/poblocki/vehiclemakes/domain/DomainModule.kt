package com.poblocki.vehiclemakes.domain

import com.poblocki.vehiclemakes.domain.usecase.ChangeVehicleAsFavoriteUseCase
import com.poblocki.vehiclemakes.domain.usecase.GetAllFavoritesCountUseCase
import com.poblocki.vehiclemakes.domain.usecase.GetUserVehicleMakesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetUserVehicleMakesUseCase(get(), get()) }
    factory { GetAllFavoritesCountUseCase(get()) }
    factory { ChangeVehicleAsFavoriteUseCase(get()) }
}