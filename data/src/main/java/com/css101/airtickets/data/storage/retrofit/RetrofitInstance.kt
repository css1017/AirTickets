package com.css101.airtickets.data.storage.retrofit

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitInstance {
    private val objectMapper = ObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/css1017/AirTickets/master/api/")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build()
    }
    val ticketService: TicketService = retrofit.create(TicketService::class.java)
}