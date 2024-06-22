package com.css101.airtickets.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.css101.airtickets.databinding.ItemTicketListBinding
import com.css101.airtickets.domain.models.Ticket

class SearchTicketListAdapter(
    private val items: List<Ticket>,
    private var onItemClick: ((Ticket) -> Unit),
) : RecyclerView.Adapter<SearchTicketListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchTicketListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketListBinding.inflate(inflater, parent, false)
        return SearchTicketListViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchTicketListViewHolder, position: Int) {
        holder.bind(items[position])
        val ticket = items[position]
        holder.itemView.setOnClickListener {
            onItemClick(ticket)
        }
    }
}