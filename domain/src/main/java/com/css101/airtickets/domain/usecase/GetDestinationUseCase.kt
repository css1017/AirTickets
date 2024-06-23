package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.repository.SearchRepo

class GetDestinationUseCase(private val searchRepo: SearchRepo) {
    fun execute(): String {
        return searchRepo.getDestination() ?: ""
    }
}