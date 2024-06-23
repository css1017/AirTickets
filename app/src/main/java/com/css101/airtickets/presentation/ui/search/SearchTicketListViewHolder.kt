package com.css101.airtickets.presentation.ui.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.css101.airtickets.R
import com.css101.airtickets.databinding.ItemTicketListBinding
import com.css101.airtickets.domain.models.Ticket
import com.css101.airtickets.utils.formatPrice
import java.text.SimpleDateFormat
import java.util.Locale

class SearchTicketListViewHolder(private val binding: ItemTicketListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Ticket): Unit = with(binding) {
        val ctx = root.context
        tvPriceItem.text = ctx.getString(R.string.price, item.price.value.formatPrice())
        tvTagItem.text = item.badge
        if (!item.badge.isNullOrEmpty()) {
            tvTagItem.visibility = View.VISIBLE
        } else tvTagItem.visibility = View.GONE

        tvInfoItem.text =
            ctx.getString(R.string.ticket_info, timeInFlight(item), transferToString(item))
        tvArrivalItem.text = formatTime(item.arrival.date)
        tvArrivalPortItem.text = item.arrival.airport
        tvDepartureItem.text =
            ctx.getString(R.string.depatrure_format, formatTime(item.departure.date))
        tvDeparturePortItem.text = item.departure.airport
    }

    private fun transferToString(ticket: Ticket): String = with(binding) {
        val ctx = root.context
        return if (ticket.hasTransfer) {
            ""
        } else ctx.getString(R.string.no_transfer)
    }

    private fun timeInFlight(ticket: Ticket): String = with(binding) {
        val ctx = root.context
        val departureDate = ticket.departure.date
        val arrivalDate = ticket.arrival.date
        val flightTime = calculateFlightTime(departureDate, arrivalDate)
        return ctx.getString(R.string.in_flight_time, flightTime)
    }

    private fun calculateFlightTime(
        departureDateString: String,
        arrivalDateString: String
    ): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val departureDate = dateFormat.parse(departureDateString)
        val arrivalDate = dateFormat.parse(arrivalDateString)

        if (departureDate != null && arrivalDate != null) {
            val differenceInMillis = arrivalDate.time - departureDate.time
            val hours = differenceInMillis / (1000 * 60 * 60)
            val minutes = (differenceInMillis % (1000 * 60 * 60)) / (1000 * 60)

            return if (minutes == 0L) {
                hours.toString()
            } else {
                String.format("%.1f", hours + minutes.toFloat() / 60)
            }
        }

        return ""
    }

    private fun formatTime(dateTimeString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val date = inputFormat.parse(dateTimeString)
        return if (date != null) outputFormat.format(date) else ""
    }
}