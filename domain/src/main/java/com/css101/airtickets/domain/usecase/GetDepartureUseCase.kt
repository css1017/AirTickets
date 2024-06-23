package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.repository.SearchRepo

class GetDepartureUseCase(private val searchRepo: SearchRepo) {
    fun execute(): String {
        return searchRepo.getDeparture() ?: ""
    }
}