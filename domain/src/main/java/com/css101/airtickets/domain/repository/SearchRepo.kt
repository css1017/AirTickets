package com.css101.airtickets.domain.repository

import java.util.Date

interface SearchRepo {
    fun saveDestination(destination: String?)
    fun saveDeparture(departure: String?)
    fun getDestination(): String?
    fun getDeparture(): String?
    fun saveDate(date: Date)
    fun getDate(): Date?

}