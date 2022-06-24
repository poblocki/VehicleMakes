package com.poblocki.vehiclemakes.domain.usecase

import com.poblocki.vehiclemakes.domain.repository.FavoriteMakesRepository
import io.reactivex.rxjava3.core.Flowable

class GetAllFavoritesCountUseCase(private val favoriteMakesRepository: FavoriteMakesRepository) {

    fun getAllFavoritesCount(): Flowable<Int> =
        favoriteMakesRepository.getAllFavoritesIds()
            .map { it.size }
            .onErrorReturnItem(0)
}