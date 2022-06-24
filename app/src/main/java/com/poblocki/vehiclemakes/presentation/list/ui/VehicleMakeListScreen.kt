package com.poblocki.vehiclemakes.presentation.list.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import com.poblocki.vehiclemakes.presentation.common.theme.VehicleMakesTheme
import com.poblocki.vehiclemakes.presentation.list.model.UiModel
import com.poblocki.vehiclemakes.presentation.list.model.VehicleUiModel

@ExperimentalMaterialApi
@Composable
fun VehicleMakeListScreen(uiModel: UiModel, onToggleClick: (VehicleMakeId) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        VehicleMakesScreen(uiModel = uiModel, onToggleClick = onToggleClick)
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun VehicleMakeListScreenPreview() {
    VehicleMakesTheme {
        VehicleMakeListScreen(
            uiModel = UiModel.Result(
                listOf(
                    VehicleUiModel(
                        id = VehicleMakeId("ABC"),
                        name = "Audi",
                        isFavorite = true
                    ),
                    VehicleUiModel(
                        id = VehicleMakeId("CDF"),
                        name = "Mercedes",
                        isFavorite = false
                    )
                )
            ),
            onToggleClick = {}
        )
    }
}