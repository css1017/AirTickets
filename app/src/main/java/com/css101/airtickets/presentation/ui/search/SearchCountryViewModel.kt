package com.css101.airtickets.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.airtickets.domain.models.Flight
import com.css101.airtickets.domain.usecase.GetDateUseCase
import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.GetDestinationUseCase
import com.css101.airtickets.domain.usecase.GetDirectFlightsUseCase
import com.css101.airtickets.domain.usecase.SaveDateUseCase
import com.css101.airtickets.domain.usecase.SaveDepartureUseCase
import com.css101.airtickets.domain.usecase.SaveDestinationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class SearchCountryViewModel(
    getDestinationUseCase: GetDestinationUseCase,
    getDepartureUseCase: GetDepartureUseCase,
    private val getDateUseCase: GetDateUseCase,
    private val getDirectFlightsUseCase: GetDirectFlightsUseCase,
    private val saveDestinationUseCase: SaveDestinationUseCase,
    private val saveDepartureUseCase: SaveDepartureUseCase,
    private val saveDateUseCase: SaveDateUseCase
) : ViewModel() {

    private val _destination = MutableLiveData<String>()
    val destination: LiveData<String> = _destination

    private val _departure = MutableLiveData<String>()
    val departure: LiveData<String> = _departure

    private val _date = MutableLiveData<Date>()
    val date: LiveData<Date> = _date

    init {
        _destination.value = getDestinationUseCase.execute()
        _departure.value = getDepartureUseCase.execute()
        if (getDateUseCase.execute() != null) {
            _date.value = getDateUseCase.execute()
        } else _date.value =
            Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())
    }
fun updateDate(){
    _date.value = getDateUseCase.execute()
}
    private val _directFlights = MutableLiveData<List<Flight>>()
    val directFlights: LiveData<List<Flight>> = _directFlights

    fun getDirectFlights() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getDirectFlightsUseCase.execute()
            _directFlights.postValue(data)
        }
    }

    fun setDestination(destination: String?) {
        saveDestinationUseCase.execute(destination)
    }

    fun setDeparture(departure: String?) {
        saveDepartureUseCase.execute(departure)
    }

    fun saveDate(date: Date) {
        saveDateUseCase.execute(date)
    }

}