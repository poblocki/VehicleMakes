package com.poblocki.vehiclemakes.presentation.count

import com.poblocki.vehiclemakes.domain.usecase.GetAllFavoritesCountUseCase
import com.poblocki.vehiclemakes.presentation.count.model.FavoriteCountUiModel
import com.poblocki.vehiclemakes.presentation.count.model.FavoriteCountUiModelMapper
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Flowable
import org.junit.Test

class FavoriteCountViewModelTest {

    private val getAllFavoritesCountUseCase: GetAllFavoritesCountUseCase = mockk {
        every { getAllFavoritesCount() } returns Flowable.just(12)
    }
    private val favoriteCountUiModelMapper: FavoriteCountUiModelMapper =
        FavoriteCountUiModelMapper()
    private val systemUnderTest =
        FavoriteCountViewModel(getAllFavoritesCountUseCase, favoriteCountUiModelMapper)

    @Test
    fun getViewState() {

        systemUnderTest.state
            .test()
            .assertValue(FavoriteCountUiModel(12))

        verify { getAllFavoritesCountUseCase.getAllFavoritesCount() }
    }
}