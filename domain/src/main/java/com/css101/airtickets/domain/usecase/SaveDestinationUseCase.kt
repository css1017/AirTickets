package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.repository.SearchRepo

class SaveDestinationUseCase(private val searchRepo: SearchRepo) {
    fun execute(destination: String?) {
        searchRepo.saveDestination(destination)
    }
}