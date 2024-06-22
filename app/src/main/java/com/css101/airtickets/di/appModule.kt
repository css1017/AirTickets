package com.css101.airtickets.di

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
}
