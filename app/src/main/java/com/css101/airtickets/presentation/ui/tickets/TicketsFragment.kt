package com.css101.airtickets.presentation.ui.tickets

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.fragment.app.Fragment
import com.css101.airtickets.R
import com.css101.airtickets.databinding.FragmentTicketsBinding
import com.css101.airtickets.domain.models.Music
import com.css101.airtickets.domain.models.SearchMode
import com.css101.airtickets.presentation.ui.search.SearchDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModel<TicketsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        vm.getInitData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtons()
        showEmptyMusic()
        vm.musicData.observe(viewLifecycleOwner) {
            setAdapter(it)
        }
        vm.savedDeparture.observe(viewLifecycleOwner) {
            setDeparture(it)
        }
    }

    private fun setDeparture(departure: String) = with(binding) {
        if (departure.isNotEmpty()) {
            inclSearchTickets.tvFrom.text = departure
            inclSearchTickets.tvFrom.setTextColor(
                getColor(
                    resources,
                    R.color.text_dark,
                    null
                )
            )
        } else {
            inclSearchTickets.tvFrom.text = getString(R.string.from_hint)
            inclSearchTickets.tvFrom.setTextColor(
                getColor(
                    resources,
                    R.color.text_accent_dark,
                    null
                )
            )
        }
    }

    private fun setButtons() = with(binding) {
        inclSearchTickets.tvFrom.setOnClickListener {
            val dialog = SearchDialogFragment.newInstance(SearchMode.From)
            dialog.show(childFragmentManager, "search")
        }
        inclSearchTickets.tvWhere.setOnClickListener {
            val dialog = SearchDialogFragment.newInstance(SearchMode.To)
            dialog.show(childFragmentManager, "search")
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setAdapter(musicData: List<Music>) {
        if (musicData.isEmpty()) {
            showEmptyMusic()
        } else showMusic()
        binding.rvMusic.adapter = MusicAdapter(musicData) {}
        binding.rvMusic.adapter?.notifyDataSetChanged()
    }

    private fun showEmptyMusic() = with(binding) {
        rvMusic.visibility = View.GONE
        tvTitleMusic.visibility = View.GONE
    }

    private fun showMusic() = with(binding) {
        rvMusic.visibility = View.VISIBLE
        tvTitleMusic.visibility = View.VISIBLE

    }

    override fun onResume() {
        super.onResume()
        vm.updateDeparture()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}