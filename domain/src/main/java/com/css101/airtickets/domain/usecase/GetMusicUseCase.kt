package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.models.Music
import com.css101.airtickets.domain.models.Price

class GetMusicUseCase {

    fun execute(): List<Music> {
        // todo https://run.mocky.io/v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a
        return listOf(
            Music(1, "Die Antwoord", "Будапешт", Price(5000)),
            Music(2, "Socrat&Lera", "Санкт-Петербург", Price(1999)),
            Music(3, "Лампабикт", "Москва", Price(2390)),
        )
    }
}