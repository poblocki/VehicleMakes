package com.poblocki.vehiclemakes.presentation.list.model

import com.poblocki.vehiclemakes.domain.model.VehicleMakeId

data class VehicleUiModel(
    val id: VehicleMakeId,
    val name: String,
    val isFavorite: Boolean
)