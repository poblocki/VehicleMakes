package com.poblocki.vehiclemakes.presentation.count

import com.poblocki.vehiclemakes.domain.usecase.GetAllFavoritesCountUseCase
import com.poblocki.vehiclemakes.presentation.common.BaseViewModel
import com.poblocki.vehiclemakes.presentation.count.model.FavoriteCountUiModel
import com.poblocki.vehiclemakes.presentation.count.model.FavoriteCountUiModelMapper
import io.reactivex.rxjava3.core.Flowable

class FavoriteCountViewModel(
    getAllFavoritesCountUseCase: GetAllFavoritesCountUseCase,
    private val favoriteCountUiModelMapper: FavoriteCountUiModelMapper
) : BaseViewModel() {

    val state: Flowable<FavoriteCountUiModel> = getAllFavoritesCountUseCase.getAllFavoritesCount()
        .map(favoriteCountUiModelMapper::map)
        .onErrorReturnItem(FavoriteCountUiModel())
}