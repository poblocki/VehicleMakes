package com.poblocki.vehiclemakes.presentation.list.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import com.poblocki.vehiclemakes.presentation.common.theme.VehicleMakesTheme
import com.poblocki.vehiclemakes.presentation.list.model.UiModel

@ExperimentalMaterialApi
@Composable
fun VehicleMakesScreen(uiModel: UiModel, onToggleClick: (VehicleMakeId) -> Unit) {
    when (uiModel) {
        is UiModel.Error -> Text(text = "Error!")
        is UiModel.Loading -> Text(text = "Loading...")
        is UiModel.Result -> {
            LazyColumn {
                items(uiModel.items) {
                    VehicleMakeScreen(uiModel = it, onToggleClick = onToggleClick)
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
fun VehicleMakesScreenPreview(uiModel: UiModel, onToggleClick: (VehicleMakeId) -> Unit) {
    VehicleMakesTheme {
        VehicleMakesScreen(uiModel = UiModel.Loading, onToggleClick = {})
    }
}