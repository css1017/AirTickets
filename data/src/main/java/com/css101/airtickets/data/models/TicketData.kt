package com.css101.airtickets.data.models

import com.fasterxml.jackson.annotation.JsonProperty
data class TicketData(
    @JsonProperty("tickets")
    val tickets: List<Tickets>
)
data class Tickets(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("badge")
    val badge: String?,
    @JsonProperty("price")
    val price: PriceTicket,
    @JsonProperty("provider_name")
    val providerName: String,
    @JsonProperty("company")
    val company: String,
    @JsonProperty("departure")
    val departure: Departure,
    @JsonProperty("arrival")
    val arrival: Arrival,
    @JsonProperty("has_transfer")
    val hasTransfer: Boolean,
    @JsonProperty("has_visa_transfer")
    val hasVisaTransfer: Boolean,
    @JsonProperty("luggage")
    val luggage: Luggage,
    @JsonProperty("hand_luggage")
    val handLuggage: HandLuggage,
    @JsonProperty("is_returnable")
    val isReturnable: Boolean,
    @JsonProperty("is_exchangable")
    val isExchangeable: Boolean
)

data class PriceTicket(
    @JsonProperty("value")
    val value: Int
)

data class Departure(
    @JsonProperty("town")
    val town: String,
    @JsonProperty("date")
    val date: String,
    @JsonProperty("airport")
    val airport: String
)

data class Arrival(
    @JsonProperty("town")
    val town: String,
    @JsonProperty("date")
    val date: String,
    @JsonProperty("airport")
    val airport: String
)

data class Luggage(
    @JsonProperty("has_luggage")
    val hasLuggage: Boolean,
    @JsonProperty("price")
    val price: PriceTicket?
)

data class HandLuggage(
    @JsonProperty("has_hand_luggage")
    val hasHandLuggage: Boolean,
    @JsonProperty("size")
    val size: String?
)