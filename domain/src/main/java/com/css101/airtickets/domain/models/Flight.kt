package com.css101.airtickets.domain.models

data class Flight( //tickets_offers
    val id: Int,
    val title: String,
    val timeRange: List<String>, //time_range
    val price: PriceFlight
)

data class PriceFlight(
    val value: Int
)