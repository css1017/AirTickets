package com.css101.airtickets.domain.models

data class Ticket(
    val id: Int,
    val badge: String?,
    val price: PriceTicket,
    val providerName: String, //provider_name
    val company: String,
    val departure: Departure,
    val arrival: Arrival,
    val hasTransfer: Boolean, //has_transfer
    val hasVisaTransfer: Boolean, //has_visa_transfer
    val luggage: Luggage,
    val handLuggage: HandLuggage, //hand_luggage
    val isReturnable: Boolean, //is_returnable
    val isExchangeable: Boolean //is_exchangable
)

data class PriceTicket(
    val value: Int
)

data class Departure(
    val town: String,
    val date: String,
    val airport: String
)

data class Arrival(
    val town: String,
    val date: String,
    val airport: String
)

data class Luggage(
    val hasLuggage: Boolean, //has_luggage
    val price: Price?
)

data class HandLuggage(
    val hasHandLuggage: Boolean, //has_hand_luggage
    val size: String?
)