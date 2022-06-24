package com.poblocki.vehiclemakes.presentation.count.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.poblocki.vehiclemakes.presentation.common.theme.VehicleMakesTheme
import com.poblocki.vehiclemakes.presentation.count.model.FavoriteCountUiModel

@Composable
fun FavoriteCountScreen(navController: NavController, uiModel: FavoriteCountUiModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FavoriteCount(uiModel.count)
            Button(
                modifier = Modifier.padding(PaddingValues(top = 24.dp)),
                onClick = { navController.navigate("makes") }) {
                Text(
                    text = "Choose favorites",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
@Preview
fun FavoriteCountScreenPreview() {
    VehicleMakesTheme {
        FavoriteCountScreen(
            navController = rememberNavController(),
            uiModel = FavoriteCountUiModel(11)
        )
    }
}