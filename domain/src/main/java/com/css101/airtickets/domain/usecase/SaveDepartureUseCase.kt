package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.repository.SearchRepo

class SaveDepartureUseCase(private val searchRepo: SearchRepo) {
    fun execute(departure: String?) {
        searchRepo.saveDeparture(departure)
    }
}