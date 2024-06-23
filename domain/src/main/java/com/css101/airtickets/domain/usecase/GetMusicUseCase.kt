package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.models.Music
import com.css101.airtickets.domain.repository.TicketsRepo

class GetMusicUseCase(private val ticketsRepo: TicketsRepo) {

    suspend fun execute(): List<Music> {
        return ticketsRepo.getMusic()
    }
}