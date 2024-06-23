package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.repository.SearchRepo
import java.util.Date

class GetDateUseCase(private val searchRepo: SearchRepo) {
    fun execute(): Date? {
        return searchRepo.getDate()
    }

}