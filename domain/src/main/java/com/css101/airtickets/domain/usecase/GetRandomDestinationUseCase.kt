package com.css101.airtickets.domain.usecase

import kotlin.random.Random

class GetRandomDestinationUseCase {
    fun execute(): String {
        val stringList = listOf(
            "Екатеринбург",
            "Санкт-Петербург",
            "Новосибирск",
            "Воронеж",
            "Тблилиси",
            "Батуми",
            "Пхукет",
            "Сочи",
            "Стамбул",
            "Париж",
            "Лондон",
            "Рим",
            "Барселона",
            "Нью-Йорк",
            "Токио",
            "Дубай",
            "Сингапур",
            "Сидней",
            "Минск",
            "Бангкок"
        )

        val randomIndex = Random.nextInt(stringList.size)
        return stringList[randomIndex]
    }
}