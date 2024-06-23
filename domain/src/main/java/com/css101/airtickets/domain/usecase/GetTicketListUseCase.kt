package com.css101.airtickets.domain.usecase

import com.css101.airtickets.domain.models.Arrival
import com.css101.airtickets.domain.models.Departure
import com.css101.airtickets.domain.models.HandLuggage
import com.css101.airtickets.domain.models.Luggage
import com.css101.airtickets.domain.models.Price
import com.css101.airtickets.domain.models.PriceTicket
import com.css101.airtickets.domain.models.Ticket

class GetTicketListUseCase {
    fun execute(from: String?, to: String? ) : List<Ticket>{
        return if (!from.isNullOrEmpty() && !to.isNullOrEmpty()){
            listOf(Ticket(
                id = 3064,
                badge = "accumsan",
                price = PriceTicket(value = 8691),
                providerName = "Omar McNeil",
                company = "ius",
                departure = Departure(
                    town = "dignissim",
                    date = "2024-02-23T03:15:00",
                    airport = "VKO"
                ),
                arrival = Arrival(
                    town = "amet",
                    date = "2024-02-23T07:10:00",
                    airport = "AER"
                ),
                hasTransfer = false,
                hasVisaTransfer = false,
                luggage = Luggage(
                    hasLuggage = false,
                    price = Price(value = 2210)
                ),
                handLuggage = HandLuggage(
                    hasHandLuggage = false,
                    size = "theophrastus"
                ),
                isReturnable = false,
                isExchangeable = false
            ),
                Ticket(
                    id = 9201,
                    badge = null,
                    price = PriceTicket(value = 1888),
                    providerName = "Ollie Warner",
                    company = "consectetur",
                    departure = Departure(
                        town = "noster",
                        date = "024-02-23T15:00:00",
                        airport = "SVO"
                    ),
                    arrival = Arrival(
                        town = "accumsan",
                        date = "024-02-23T18:40:00",
                        airport = "BUS"
                    ),
                    hasTransfer = false,
                    hasVisaTransfer = false,
                    luggage = Luggage(
                        hasLuggage = false,
                        price = Price(value = 8020)
                    ),
                    handLuggage = HandLuggage(
                        hasHandLuggage = false,
                        size = "errem"
                    ),
                    isReturnable = false,
                    isExchangeable = false
                ))
        } else {
            emptyList()
        }
    }
}