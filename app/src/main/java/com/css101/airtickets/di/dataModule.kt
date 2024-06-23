package com.css101.airtickets.di

import com.css101.airtickets.data.repository.SearchRepoImpl
import com.css101.airtickets.data.repository.TicketRepoImpl
import com.css101.airtickets.data.storage.SearchStorage
import com.css101.airtickets.data.storage.TicketStorage
import com.css101.airtickets.data.storage.retrofit.RetrofitStorage
import com.css101.airtickets.data.storage.sharedprefs.SearchSharedPrefsStorage
import com.css101.airtickets.domain.repository.SearchRepo
import com.css101.airtickets.domain.repository.TicketsRepo
import org.koin.dsl.module

val dataModule = module {
    single<SearchRepo> {
        SearchRepoImpl(get())
    }
    single<SearchStorage> {
        SearchSharedPrefsStorage(get())
    }
    single<TicketsRepo> {
        TicketRepoImpl(get())
    }
    single<TicketStorage> {
        RetrofitStorage()
    }
}