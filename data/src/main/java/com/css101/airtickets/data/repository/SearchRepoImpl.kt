package com.css101.airtickets.data.repository

import com.css101.airtickets.data.storage.SearchStorage
import com.css101.airtickets.domain.repository.SearchRepo
import java.util.Date

class SearchRepoImpl(private val searchStorage: SearchStorage) : SearchRepo {
    override fun saveDestination(destination: String?) {
        searchStorage.saveDestination(destination)
    }

    override fun saveDeparture(departure: String?) {
        searchStorage.saveDeparture(departure)
    }

    override fun getDestination(): String? {
        return searchStorage.getDestination()
    }

    override fun getDeparture(): String? {
        return searchStorage.getDeparture()
    }

    override fun saveDate(date: Date) {
        searchStorage.saveDate(date)
    }

    override fun getDate(): Date? {
        return searchStorage.getDate()
    }
}