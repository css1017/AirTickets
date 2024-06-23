package com.css101.airtickets.data.storage

interface SearchStorage {
    fun saveDestination(destination: String?)
    fun saveDeparture(departure: String?)
    fun getDestination(): String?
    fun getDeparture(): String?

}