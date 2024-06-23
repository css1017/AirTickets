package com.css101.airtickets.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.css101.airtickets.domain.models.SearchMode
import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.GetDestinationUseCase
import com.css101.airtickets.domain.usecase.GetRandomDestinationUseCase
import com.css101.airtickets.domain.usecase.SaveDepartureUseCase
import com.css101.airtickets.domain.usecase.SaveDestinationUseCase

class SearchViewModel(
    private val getDepartureUseCase: GetDepartureUseCase,
    private val getDestinationUseCase: GetDestinationUseCase,
    private val saveDepartureUseCase: SaveDepartureUseCase,
    private val saveDestinationUseCase: SaveDestinationUseCase,
    private val getRandomDestinationUseCase: GetRandomDestinationUseCase
) : ViewModel() {

    private val _mode = MutableLiveData<SearchMode>()
    val mode: LiveData<SearchMode> = _mode
    var isFirstAppearance = true

    fun saveMode(mode: SearchMode?) {
        if (mode != null) {
            _mode.value = mode!! //for some reason shows as an error in ide without !!
        }
    }

    private val _departure = MutableLiveData<String>()
    val departure: LiveData<String> = _departure

    private val _destination = MutableLiveData<String>()
    val destination: LiveData<String> = _destination

    fun initSearch() {
        _departure.value = getDepartureUseCase.execute()
        _destination.value = getDestinationUseCase.execute()
    }


    fun saveToCity(city: String) {
        saveDestinationUseCase.execute(city)
    }

    fun saveFromCity(destination: String) {
        saveDepartureUseCase.execute(destination)
    }

    fun getRandomDestination(): String {
        return getRandomDestinationUseCase.execute()

    }
}