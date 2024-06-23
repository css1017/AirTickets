package com.css101.airtickets.data.storage.retrofit

import com.css101.airtickets.data.models.FlightData
import com.css101.airtickets.data.models.MusicData
import com.css101.airtickets.data.models.TicketData
import retrofit2.http.GET

interface TicketService {
    @GET("ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun getMusic(): MusicData

    @GET("c0464573-5a13-45c9-89f8-717436748b69")
    suspend fun getTicketList(): TicketData

    @GET("38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a")
    suspend fun getDirectFlights(): FlightData
}