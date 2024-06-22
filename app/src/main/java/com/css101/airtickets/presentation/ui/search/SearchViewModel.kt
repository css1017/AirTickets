package com.css101.airtickets.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.css101.airtickets.domain.models.SearchMode
import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.SaveDepartureUseCase
import com.css101.airtickets.domain.usecase.SaveDestinationUseCase

class SearchViewModel(
    private val getDepartureUseCase: GetDepartureUseCase,
    private val saveDepartureUseCase: SaveDepartureUseCase,
    private val saveDestinationUseCase: SaveDestinationUseCase
) : ViewModel() {

    private val _mode = MutableLiveData<SearchMode>()
    val mode: LiveData<SearchMode> = _mode

    fun saveMode(mode: SearchMode?) {
        if (mode != null) {
            _mode.value = mode!! //doesn't work without !! for some reason
        }
    }

    private val _departure = MutableLiveData<String>()
    val departure: LiveData<String> = _departure

    init {
        _departure.value = getDepartureUseCase.execute()
    }

    fun saveToCity(city: String) {
        saveDepartureUseCase.execute(city)
    }

    fun saveDestination(destination: String) {
        saveDestinationUseCase.execute(destination)

    }
}