package com.css101.airtickets.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.airtickets.domain.models.Ticket
import com.css101.airtickets.domain.usecase.GetDateUseCase
import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.GetDestinationUseCase
import com.css101.airtickets.domain.usecase.GetTicketListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class SearchTicketListViewModel(
    private val getTicketListUseCase: GetTicketListUseCase,
    private val getDepartureUseCase: GetDepartureUseCase,
    private val getDestinationUseCase: GetDestinationUseCase,
    private val getDateUseCase: GetDateUseCase
) : ViewModel() {
    private val _tickets = MutableLiveData<List<Ticket>>()
    val tickets: LiveData<List<Ticket>> = _tickets

    fun getAllTickets() {
        if (_tickets.value == null) {
            viewModelScope.launch(Dispatchers.IO) {
                _tickets.postValue(getTicketListUseCase.execute())
            }
        }
    }

    private val _departure = MutableLiveData<String>()
    val departure: LiveData<String> = _departure
    private val _arrival = MutableLiveData<String>()
    val arrival: LiveData<String> = _arrival
    private val _date = MutableLiveData<Date>()
    val date: LiveData<Date> = _date

    fun getSearchData(){
        _departure.value = getDepartureUseCase.execute()
        _arrival.value = getDestinationUseCase.execute()
        if (getDateUseCase.execute() != null) {
            _date.value = getDateUseCase.execute()
        } else _date.value =
            Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())
    }
}