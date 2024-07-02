package com.css101.airtickets.data.storage.retrofit

import com.css101.airtickets.data.models.FlightData
import com.css101.airtickets.data.models.MusicData
import com.css101.airtickets.data.models.TicketData
import retrofit2.http.GET

interface TicketService {
    @GET("offers.json")
    suspend fun getMusic(): MusicData

    @GET("tickets.json")
    suspend fun getTicketList(): TicketData

    @GET("offers_tickets.json")
    suspend fun getDirectFlights(): FlightData
}