package com.css101.airtickets.ui.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.css101.airtickets.databinding.FragmentTicketsBinding
import com.css101.airtickets.models.SearchMode
import com.css101.airtickets.ui.search.SearchDialogFragment

class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ticketsViewModel = ViewModelProvider(this)[TicketsViewModel::class.java]
        _binding = FragmentTicketsBinding.inflate(inflater, container, false)

        ticketsViewModel.text.observe(viewLifecycleOwner) {
           // binding.tvTickets.text = it
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        inclSearchTickets.tvFrom.setOnClickListener {
            val dialog = SearchDialogFragment.newInstance(SearchMode.From)
            dialog.show(childFragmentManager, "search")
        }
        inclSearchTickets.tvWhere.setOnClickListener {
            val dialog = SearchDialogFragment.newInstance(SearchMode.To)
            dialog.show(childFragmentManager, "search")
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}