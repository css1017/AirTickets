package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.repository.SearchRepo
import java.util.Date

class SaveDateUseCase(private val searchRepo: SearchRepo) {
    fun execute(date: Date) {
        searchRepo.saveDate(date)
    }

}