package com.css101.airtickets.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.airtickets.domain.models.Flight
import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.GetDestinationUseCase
import com.css101.airtickets.domain.usecase.GetDirectFlightsUseCase
import com.css101.airtickets.domain.usecase.SaveDepartureUseCase
import com.css101.airtickets.domain.usecase.SaveDestinationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchCountryViewModel(
    private val getDestinationUseCase: GetDestinationUseCase,
    private val getDepartureUseCase: GetDepartureUseCase,
    private val getDirectFlightsUseCase: GetDirectFlightsUseCase,
    private val saveDestinationUseCase: SaveDestinationUseCase,
    private val saveDepartureUseCase: SaveDepartureUseCase
) : ViewModel() {

    private val _destination = MutableLiveData<String>()
    val destination: LiveData<String> = _destination

    private val _departure = MutableLiveData<String>()
    val departure: LiveData<String> = _departure

    init {
        _destination.value = getDestinationUseCase.execute()
        _departure.value = getDepartureUseCase.execute()
    }

    private val _directFlights = MutableLiveData<List<Flight>>()
    val directFlights: LiveData<List<Flight>> = _directFlights

    fun getDirectFlights() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getDirectFlightsUseCase.execute(departure.value!!, destination.value!!)
            _directFlights.postValue(data)
        }
    }

    fun setDestination(destination: String?) {
        saveDestinationUseCase.execute(destination)
    }
    fun setDeparture(departure: String?) {
        saveDepartureUseCase.execute(departure)
    }
}