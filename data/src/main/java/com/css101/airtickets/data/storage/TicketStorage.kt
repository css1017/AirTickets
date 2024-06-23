package com.css101.airtickets.data.storage

import com.css101.airtickets.data.models.FlightData
import com.css101.airtickets.data.models.MusicData
import com.css101.airtickets.data.models.TicketData

interface TicketStorage {
    suspend fun getMusic(): MusicData
    suspend fun getTicketList(): TicketData
    suspend fun getDirectFlights(): FlightData
}