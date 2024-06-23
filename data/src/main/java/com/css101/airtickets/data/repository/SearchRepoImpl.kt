package com.css101.airtickets.data.repository

import com.css101.airtickets.data.storage.SearchStorage
import com.css101.airtickets.domain.repository.SearchRepo

class SearchRepoImpl(private val searchStorage: SearchStorage): SearchRepo {
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
}