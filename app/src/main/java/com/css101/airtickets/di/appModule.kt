package com.css101.airtickets.di

import com.css101.airtickets.presentation.ui.search.SearchCountryViewModel
import com.css101.airtickets.presentation.ui.search.SearchTicketListViewModel
import com.css101.airtickets.presentation.ui.search.SearchViewModel
import com.css101.airtickets.presentation.ui.tickets.TicketsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        TicketsViewModel(
            getMusicUseCase = get(),
            getDepartureUseCase = get()
        )
    }
    viewModel{
        SearchViewModel(
            getDepartureUseCase = get(),
            saveDepartureUseCase = get(),
            saveDestinationUseCase = get(),
            getRandomDestinationUseCase = get(),
            getDestinationUseCase = get()
        )
    }
    viewModel {
        SearchCountryViewModel(
            getDestinationUseCase = get(),
            getDepartureUseCase = get(),
            getDirectFlightsUseCase = get(),
            saveDestinationUseCase = get(),
            saveDepartureUseCase = get()
        )
    }
    viewModel {
        SearchTicketListViewModel(
            getTicketListUseCase = get(),
            getDepartureUseCase = get(),
            getDestinationUseCase = get()
        )
    }
}
