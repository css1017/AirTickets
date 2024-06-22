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
                    date = "option",
                    airport = "imperdiet"
                ),
                arrival = Arrival(
                    town = "amet",
                    date = "vituperata",
                    airport = "inani"
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
                    badge = "quaerendum",
                    price = PriceTicket(value = 1888),
                    providerName = "Ollie Warner",
                    company = "consectetur",
                    departure = Departure(
                        town = "noster",
                        date = "himenaeos",
                        airport = "lacinia"
                    ),
                    arrival = Arrival(
                        town = "accumsan",
                        date = "referrentur",
                        airport = "fringilla"
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