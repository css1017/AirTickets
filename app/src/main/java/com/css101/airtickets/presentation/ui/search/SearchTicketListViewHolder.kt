package com.css101.airtickets.presentation.ui.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.css101.airtickets.R
import com.css101.airtickets.databinding.ItemTicketListBinding
import com.css101.airtickets.domain.models.Ticket
import com.css101.airtickets.utils.formatPrice

class SearchTicketListViewHolder(private val binding: ItemTicketListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Ticket): Unit = with(binding) {
        val ctx = root.context
        tvPriceItem.text = ctx.getString(R.string.price, item.price.value.formatPrice())

        if (item.badge.isNotEmpty()) {
            tvTagItem.visibility = View.VISIBLE
            tvTagItem.text = item.badge
        } else tvTagItem.visibility = View.GONE

        tvInfoItem //3.5 ч в пути/Без пересадок
        tvArrivalItem
        tvArrivalPortItem
        tvDepartureItem
        tvDeparturePortItem
    }
}