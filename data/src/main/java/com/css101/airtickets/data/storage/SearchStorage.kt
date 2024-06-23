package com.css101.airtickets.data.storage

import java.util.Date

interface SearchStorage {
    fun saveDestination(destination: String?)
    fun saveDeparture(departure: String?)
    fun getDestination(): String?
    fun getDeparture(): String?
    fun saveDate(date: Date?)
    fun getDate(): Date?


}