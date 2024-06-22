package com.css101.airtickets.domain.models

data class Music(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price
)

data class Price(
    val value: Int
)
