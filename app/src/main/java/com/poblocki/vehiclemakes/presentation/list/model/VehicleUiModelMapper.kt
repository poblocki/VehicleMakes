package com.poblocki.vehiclemakes.presentation.list.model

import com.poblocki.vehiclemakes.domain.model.UserVehicleMake

class VehicleUiModelMapper {

    fun map(list: List<UserVehicleMake>): UiModel =
        UiModel.Result(items = list.map(::toUiModel))

    private fun toUiModel(userVehicleMake: UserVehicleMake): VehicleUiModel =
        with(userVehicleMake) {
            VehicleUiModel(
                id = vehicleMake.id,
                name = vehicleMake.name,
                isFavorite = isFavorite
            )
        }
}