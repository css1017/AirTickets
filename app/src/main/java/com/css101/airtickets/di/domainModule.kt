package com.css101.airtickets.di

import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.GetDestinationUseCase
import com.css101.airtickets.domain.usecase.GetDirectFlightsUseCase
import com.css101.airtickets.domain.usecase.GetMusicUseCase
import com.css101.airtickets.domain.usecase.GetRandomDestinationUseCase
import com.css101.airtickets.domain.usecase.GetTicketListUseCase
import com.css101.airtickets.domain.usecase.SaveDepartureUseCase
import com.css101.airtickets.domain.usecase.SaveDestinationUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMusicUseCase(get())
    }
    factory {
        GetDepartureUseCase(get())
    }
    factory {
        SaveDestinationUseCase(get())
    }
    factory {
        SaveDepartureUseCase(get())
    }
    factory {
        GetDestinationUseCase(get())
    }
    factory {
        GetDirectFlightsUseCase(get())
    }
    factory {
        GetTicketListUseCase(get())
    }
    factory {
        GetRandomDestinationUseCase()
    }
}