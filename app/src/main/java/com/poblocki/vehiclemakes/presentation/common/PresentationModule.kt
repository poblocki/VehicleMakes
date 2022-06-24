package com.poblocki.vehiclemakes.presentation.common

import com.poblocki.vehiclemakes.presentation.count.FavoriteCountViewModel
import com.poblocki.vehiclemakes.presentation.count.model.FavoriteCountUiModelMapper
import com.poblocki.vehiclemakes.presentation.list.VehicleMakeListViewModel
import com.poblocki.vehiclemakes.presentation.list.model.VehicleUiModelMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { FavoriteCountViewModel(get(), get()) }
    viewModel { VehicleMakeListViewModel(get(), get(), get(), get()) }

    factory { FavoriteCountUiModelMapper() }
    factory { VehicleUiModelMapper() }
}