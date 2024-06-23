package com.css101.airtickets.data.models

import com.fasterxml.jackson.annotation.JsonProperty

data class FlightData(
    @JsonProperty("tickets_offers")
    val ticketsOffers: List<TicketsOffers>
)
data class TicketsOffers(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("time_range")
    val timeRange: List<String>,
    @JsonProperty("price")
    val price: PriceFlight
)

data class PriceFlight(
    @JsonProperty("value")
    val value: Int
)