package com.poblocki.vehiclemakes.presentation.list

import android.util.Log
import com.poblocki.vehiclemakes.common.AppSchedulers
import com.poblocki.vehiclemakes.domain.model.VehicleMakeId
import com.poblocki.vehiclemakes.domain.usecase.ChangeVehicleAsFavoriteUseCase
import com.poblocki.vehiclemakes.domain.usecase.GetUserVehicleMakesUseCase
import com.poblocki.vehiclemakes.presentation.common.BaseViewModel
import com.poblocki.vehiclemakes.presentation.list.model.UiModel
import com.poblocki.vehiclemakes.presentation.list.model.VehicleUiModelMapper
import io.reactivex.rxjava3.core.Flowable

class VehicleMakeListViewModel(
    getAllVehicleMakesUseCase: GetUserVehicleMakesUseCase,
    private val changeVehicleAsFavoriteUseCase: ChangeVehicleAsFavoriteUseCase,
    private val appSchedulers: AppSchedulers,
    private val vehicleUiModelMapper: VehicleUiModelMapper
) : BaseViewModel() {

    val state: Flowable<UiModel> = getAllVehicleMakesUseCase.getUserVehicles()
        .map(vehicleUiModelMapper::map)
        .onErrorReturnItem(UiModel.Error)

    fun onToggleClick(id: VehicleMakeId) {
        changeVehicleAsFavoriteUseCase.changeStateFor(id)
            .subscribeOn(appSchedulers.computation)
            .observeOn(appSchedulers.mainThread)
            .subscribe(
                {
                    Log.d(
                        "VehicleMakeListViewModel",
                        "Successfully toggled as favorite $id",
                    )
                },
                {
                    Log.d(
                        "VehicleMakeListViewModel",
                        "Error when saving as favorite $id",
                        it
                    )
                }
            )
            .remember()
    }
}