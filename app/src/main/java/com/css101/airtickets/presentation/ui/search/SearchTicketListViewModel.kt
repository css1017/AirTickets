package com.css101.airtickets.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.airtickets.domain.models.Ticket
import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.GetDestinationUseCase
import com.css101.airtickets.domain.usecase.GetTicketListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchTicketListViewModel(
    private val getTicketListUseCase: GetTicketListUseCase,
    private val getDepartureUseCase: GetDepartureUseCase,
    private val getDestinationUseCase: GetDestinationUseCase
) : ViewModel() {
    private val _tickets = MutableLiveData<List<Ticket>>()
    val tickets: LiveData<List<Ticket>> = _tickets

    fun getAllTickets() {
        if (_tickets.value == null) {
            viewModelScope.launch(Dispatchers.IO) {
                val departure = getDepartureUseCase.execute()
                val destination = getDestinationUseCase.execute()
                _tickets.postValue(getTicketListUseCase.execute(departure, destination))
            }
        }
    }

    private val _departute = MutableLiveData<String>()
    val departute: LiveData<String> = _departute
    private val _arrival = MutableLiveData<String>()
    val arrival: LiveData<String> = _arrival

    fun getSearchData(){
        _departute.value = getDepartureUseCase.execute()
        _arrival.value = getDestinationUseCase.execute()
    }
}