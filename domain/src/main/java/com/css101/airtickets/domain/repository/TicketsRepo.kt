package com.css101.airtickets.domain.repository

import com.css101.airtickets.domain.models.Flight
import com.css101.airtickets.domain.models.Music
import com.css101.airtickets.domain.models.Ticket

interface TicketsRepo {
    suspend fun getMusic(): List<Music>
    suspend fun getTicketList(): List<Ticket>
    suspend fun getDirectFlights(): List<Flight>
}