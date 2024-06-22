package com.css101.airtickets.presentation.ui.tickets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.css101.airtickets.databinding.ItemMusicBinding
import com.css101.airtickets.domain.models.Music

class MusicAdapter(
    private val items: List<Music>,
    private var onItemClick: ((Music) -> Unit),
) : RecyclerView.Adapter<MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMusicBinding.inflate(inflater, parent, false)
        return MusicViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(items[position])
        val product = items[position]
        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }
}