package com.poblocki.vehiclemakes.presentation.list.model

sealed class UiModel {

    data class Result(val items: List<VehicleUiModel>) : UiModel()
    object Loading : UiModel()
    object Error : UiModel()
}