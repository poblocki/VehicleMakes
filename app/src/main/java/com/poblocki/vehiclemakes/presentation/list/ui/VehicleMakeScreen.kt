package com.poblocki.vehiclemakes.presentation.list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.poblocki.vehiclemakes.R
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import com.poblocki.vehiclemakes.presentation.common.theme.VehicleMakesTheme
import com.poblocki.vehiclemakes.presentation.list.model.VehicleUiModel

@ExperimentalMaterialApi
@Composable
fun VehicleMakeScreen(
    uiModel: VehicleUiModel,
    onToggleClick: (VehicleMakeId) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .height(48.dp),
        backgroundColor =
        if (uiModel.isFavorite) {
            MaterialTheme.colors.primary
        } else {
            Color.White
        },
        onClick = { onToggleClick.invoke(uiModel.id) }
    ) {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(0.9f),
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                fontWeight = if (uiModel.isFavorite) {
                    FontWeight.Bold
                } else {
                    null
                },
                color = if (uiModel.isFavorite) {
                    Color.White
                } else {
                    Color.Black
                },
                text = uiModel.name
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.favorite),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
fun UserVehicleMakePreview() {
    VehicleMakesTheme {
        VehicleMakeScreen(
            VehicleUiModel(
                id = VehicleMakeId("id"),
                name = "Name",
                isFavorite = true
            ),
            onToggleClick = {}
        )
    }
}