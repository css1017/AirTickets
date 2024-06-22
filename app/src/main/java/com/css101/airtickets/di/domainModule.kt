package com.css101.airtickets.di

import com.css101.airtickets.domain.usecase.GetDepartureUseCase
import com.css101.airtickets.domain.usecase.GetMusicUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMusicUseCase()
    }
    factory {
        GetDepartureUseCase()
    }
}