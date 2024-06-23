package com.css101.airtickets.data.storage.retrofit

import com.css101.airtickets.data.models.FlightData
import com.css101.airtickets.data.models.MusicData
import com.css101.airtickets.data.models.TicketData
import com.css101.airtickets.data.storage.TicketStorage

class RetrofitStorage : TicketStorage {
    override suspend fun getMusic(): MusicData {
        return RetrofitInstance.ticketService.getMusic()
    }

    override suspend fun getTicketList(): TicketData {
        return RetrofitInstance.ticketService.getTicketList()
    }

    override suspend fun getDirectFlights(): FlightData {
        return RetrofitInstance.ticketService.getDirectFlights()

    }

}