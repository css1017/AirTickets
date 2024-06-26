package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.models.Ticket
import com.css101.airtickets.domain.repository.TicketsRepo

class GetTicketListUseCase(private val ticketsRepo: TicketsRepo) {
    suspend fun execute() : List<Ticket>{

        return ticketsRepo.getTicketList()

    }
}