package com.css101.airtickets.data.storage.retrofit

import com.css101.airtickets.data.models.FlightData
import com.css101.airtickets.data.models.MusicData
import com.css101.airtickets.data.models.TicketData
import com.css101.airtickets.data.storage.TicketStorage

class RetrofitStorage : TicketStorage {
    override suspend fun getMusic(): MusicData {
        return try {
            RetrofitInstance.ticketService.getMusic()
        } catch (e: Exception) {
            MusicData(emptyList())
        }
    }

    override suspend fun getTicketList(): TicketData {
        return try {
            RetrofitInstance.ticketService.getTicketList()
        }catch (e: Exception) {
            TicketData(emptyList())
        }
    }

    override suspend fun getDirectFlights(): FlightData {
        return try {
            RetrofitInstance.ticketService.getDirectFlights()
        }catch (e: Exception) {
            FlightData(emptyList())
        }

    }

}