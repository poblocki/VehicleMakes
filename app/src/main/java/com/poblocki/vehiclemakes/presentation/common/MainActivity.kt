package com.poblocki.vehiclemakes.presentation.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.poblocki.vehiclemakes.presentation.common.theme.VehicleMakesTheme
import com.poblocki.vehiclemakes.presentation.count.FavoriteCountViewModel
import com.poblocki.vehiclemakes.presentation.count.model.FavoriteCountUiModel
import com.poblocki.vehiclemakes.presentation.count.ui.FavoriteCountScreen
import com.poblocki.vehiclemakes.presentation.list.VehicleMakeListViewModel
import com.poblocki.vehiclemakes.presentation.list.model.UiModel
import com.poblocki.vehiclemakes.presentation.list.ui.VehicleMakeListScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VehicleMakesTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "favorites") {
                    composable("favorites") {
                        val viewModel: FavoriteCountViewModel by viewModel()
                        val state =
                            viewModel.state.subscribeAsState(initial = FavoriteCountUiModel())
                        FavoriteCountScreen(
                            navController = navController,
                            uiModel = state.value
                        )
                    }
                    composable("makes") {
                        val viewModel: VehicleMakeListViewModel by viewModel()
                        val state = viewModel.state.subscribeAsState(initial = UiModel.Loading)
                        VehicleMakeListScreen(
                            uiModel = state.value,
                            onToggleClick = viewModel::onToggleClick
                        )

                    }
                }
            }
        }
    }
}
