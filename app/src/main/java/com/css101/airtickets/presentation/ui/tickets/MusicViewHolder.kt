package com.css101.airtickets.presentation.ui.tickets

import androidx.recyclerview.widget.RecyclerView
import com.css101.airtickets.R
import com.css101.airtickets.databinding.ItemMusicBinding
import com.css101.airtickets.domain.models.Music
import com.css101.airtickets.utils.formatPrice

class MusicViewHolder(private val binding: ItemMusicBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Music): Unit = with(binding) {
        val ctx = root.context
        tvMusicPrice.text = ctx.getString(R.string.price, item.price.value.formatPrice())
        tvMusicArtist.text = item.title
        tvMusicCity.text = item.town
        when(item.id){
            1 -> ivMusicCover.setImageResource(R.drawable.artist_cover_1)
            2 -> ivMusicCover.setImageResource(R.drawable.artist_cover_2)
            3 -> ivMusicCover.setImageResource(R.drawable.artist_cover_3)
        }
    }


}