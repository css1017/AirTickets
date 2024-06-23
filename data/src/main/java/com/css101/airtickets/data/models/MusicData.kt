package com.css101.airtickets.data.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MusicData(
    @JsonProperty("offers") val offers: List<Offers>
)

data class Offers(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("town")
    val town: String,
    @JsonProperty("price")
    val price: PriceMusic
)

data class PriceMusic(
    @JsonProperty("value")
    val value: Int
)
