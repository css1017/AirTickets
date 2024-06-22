package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.models.Flight
import com.css101.airtickets.domain.models.PriceFlight

class GetDirectFlightsUseCase {
    fun execute(from: String?, to: String?): List<Flight> {
        //todo https://run.mocky.io/v3/38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a
        return if(!from.isNullOrEmpty() && !to.isNullOrEmpty()){
            listOf(
                Flight(
                    id = 3796,
                    title = "Уральские авиалинии",
                    timeRange = listOf(
                        "07:00",
                        "09:10",
                        "10:00",
                        "11:30",
                        "14:15",
                        "19:10",
                        "21:00",
                        "23:30"
                    ),
                    price = PriceFlight(value = 3999)
                ),
                Flight(
                    id = 326,
                    title = "Победа",
                    timeRange = listOf(
                        "09:10",
                        "21:00"
                    ),
                    price = PriceFlight(value = 4999)
                ),
                Flight(
                    id = 376,
                    title = "NordStar",
                    timeRange = listOf("07:00"),
                    price = PriceFlight(value = 2390)
                ),
            )
        } else{
            emptyList()
        }
    }
}