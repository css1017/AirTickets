package com.css101.airtickets.data.repository

import com.css101.airtickets.data.models.FlightData
import com.css101.airtickets.data.models.MusicData
import com.css101.airtickets.data.models.TicketData
import com.css101.airtickets.data.storage.TicketStorage
import com.css101.airtickets.domain.models.Arrival
import com.css101.airtickets.domain.models.Departure
import com.css101.airtickets.domain.models.Flight
import com.css101.airtickets.domain.models.HandLuggage
import com.css101.airtickets.domain.models.Luggage
import com.css101.airtickets.domain.models.Music
import com.css101.airtickets.domain.models.Price
import com.css101.airtickets.domain.models.PriceFlight
import com.css101.airtickets.domain.models.PriceTicket
import com.css101.airtickets.domain.models.Ticket
import com.css101.airtickets.domain.repository.TicketsRepo

class TicketRepoImpl(private val ticketsStorage: TicketStorage) : TicketsRepo {

    override suspend fun getMusic(): List<Music> {
        return dataMusicToDomain(ticketsStorage.getMusic())
    }

    override suspend fun getTicketList(): List<Ticket> {
        return dataTicketToDomain(ticketsStorage.getTicketList())
    }

    override suspend fun getDirectFlights(): List<Flight> {
        return dataFlightToDomain(ticketsStorage.getDirectFlights())
        }

    private fun dataFlightToDomain(data: FlightData): List<Flight> {
        return data.ticketsOffers.map {
            Flight(
                id = it.id,
                title = it.title,
                timeRange = it.timeRange,
                price = PriceFlight(value = it.price.value)
            )

        }
    }

    private fun dataMusicToDomain(data: MusicData): List<Music> {
        return data.offers.map {
            Music(
                id = it.id,
                title = it.title,
                town = it.town,
                price = Price(value = it.price.value))
        }
    }

    private fun dataTicketToDomain(data: TicketData): List<Ticket> {
        return data.tickets.map {
            Ticket(
                id = it.id,
                badge = it.badge,
                price = PriceTicket(value = it.price.value),
                providerName = it.providerName,
                company = it.company,
                departure = Departure(
                    town = it.departure.town,
                    date = it.departure.date,
                    airport = it.departure.airport
                ),
                arrival = Arrival(
                    town = it.arrival.town,
                    date = it.arrival.date,
                    airport = it.arrival.airport
                ),
                hasTransfer = it.hasTransfer,
                hasVisaTransfer = it.hasVisaTransfer,
                luggage = Luggage(
                    hasLuggage = it.luggage.hasLuggage,
                    price = it.luggage.price?.let { it1 -> Price(value = it1.value) }
                ),
                handLuggage = HandLuggage(
                    hasHandLuggage = it.handLuggage.hasHandLuggage,
                    size = it.handLuggage.size
                ),
                isReturnable = it.isReturnable,
                isExchangeable = it.isExchangeable

            )
        }
    }
}