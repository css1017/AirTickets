package com.css101.airtickets.presentation.ui.tickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.css101.airtickets.domain.models.Music
import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.GetMusicUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TicketsViewModel(
    private val getMusicUseCase: GetMusicUseCase,
    private val getDepartureUseCase: GetDepartureUseCase,
) : ViewModel() {

    private val _musicData = MutableLiveData<List<Music>>()
    val musicData: LiveData<List<Music>> = _musicData

    private fun getMusicData() {
        if (_musicData.value == null) {
            viewModelScope.launch(Dispatchers.IO) {
                _musicData.postValue(getMusicUseCase.execute())
            }
        }
    }

    private val _savedDeparture = MutableLiveData<String>()
    val savedDeparture: LiveData<String> = _savedDeparture

    private fun getDeparture() {
        if (_savedDeparture.value == null) {
            viewModelScope.launch(Dispatchers.IO) {
                _savedDeparture.postValue(getDepartureUseCase.execute())
            }
        }
    }

    fun updateDeparture() {
        viewModelScope.launch(Dispatchers.IO) {
            _savedDeparture.postValue(getDepartureUseCase.execute())
        }
    }

    fun getInitData() {
        getDeparture()
        getMusicData()
    }
}