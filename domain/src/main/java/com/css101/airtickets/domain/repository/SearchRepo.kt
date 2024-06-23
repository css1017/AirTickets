package com.css101.airtickets.domain.repository

interface SearchRepo {
    fun saveDestination(destination: String?)
    fun saveDeparture(departure: String?)
    fun getDestination(): String?
    fun getDeparture(): String?
}