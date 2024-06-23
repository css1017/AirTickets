package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.models.Flight
import com.css101.airtickets.domain.repository.TicketsRepo

class GetDirectFlightsUseCase(private val ticketsRepo: TicketsRepo) {
    suspend fun execute(from: String?, to: String?): List<Flight> {
        return ticketsRepo.getDirectFlights()
    }
}