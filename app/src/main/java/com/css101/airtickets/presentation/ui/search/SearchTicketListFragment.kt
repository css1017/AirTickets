package com.css101.airtickets.presentation.ui.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.css101.airtickets.R
import com.css101.airtickets.databinding.FragmentTicketListBinding
import com.css101.airtickets.domain.models.Ticket
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchTicketListFragment : Fragment() {
    private var _binding: FragmentTicketListBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModel<SearchTicketListViewModel>()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vm.getAllTickets()
        navController = findNavController()

        _binding = FragmentTicketListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        setupSearch()
        vm.tickets.observe(viewLifecycleOwner) {
            setAdapter(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setAdapter(tickets: List<Ticket>) {
        if (tickets.isEmpty()) {
            showEmptyTickets()
        } else showTickets()
        binding.rvTickets.adapter = SearchTicketListAdapter(tickets) {}
        binding.rvTickets.adapter?.notifyDataSetChanged()
    }
    private fun setupSearch() = with(binding) {
        btnBackCountry.setOnClickListener {
            navController.popBackStack()
        }
        vm.getSearchData()
        tvDirectionList.text = getString(R.string.departure_arrival, vm.departute.value, vm.arrival.value)
//        tvInfoList.text = vm.date
    }
    private fun showEmptyTickets() = with(binding) {

    }

    private fun showTickets() = with(binding) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}