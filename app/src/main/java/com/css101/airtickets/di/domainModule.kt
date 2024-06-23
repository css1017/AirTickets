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
        GetMusicUseCase()
    }
    factory {
        GetDepartureUseCase()
    }
    factory {
        SaveDestinationUseCase()
    }
    factory {
        SaveDepartureUseCase()
    }
    factory {
        GetDestinationUseCase()
    }
    factory {
        GetDirectFlightsUseCase()
    }
    factory {
        GetTicketListUseCase()
    }
    factory {
        GetRandomDestinationUseCase()
    }
}