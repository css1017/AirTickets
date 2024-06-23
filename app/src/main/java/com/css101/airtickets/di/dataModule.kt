package com.css101.airtickets.di

import com.css101.airtickets.data.repository.SearchRepoImpl
import com.css101.airtickets.data.storage.SearchStorage
import com.css101.airtickets.data.storage.sharedprefs.SearchSharedPrefsStorage
import com.css101.airtickets.domain.repository.SearchRepo
import org.koin.dsl.module

val dataModule = module {
    single<SearchRepo> {
        SearchRepoImpl(get())
    }
    single<SearchStorage> {
        SearchSharedPrefsStorage(get())
    }
}