package com.css101.airtickets.presentation.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.css101.airtickets.R
import com.css101.airtickets.databinding.FragmentCountryBinding
import com.css101.airtickets.domain.models.Flight
import com.css101.airtickets.utils.formatPrice
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchCountryFragment : Fragment() {

    private var _binding: FragmentCountryBinding? = null
    private val binding get() = _binding!!
    private val vm by viewModel<SearchCountryViewModel>()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vm.getDirectFlights()
        navController = findNavController()

        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        setupSearch()
        btnShowAllTickets.setOnClickListener {
            navController.navigate(R.id.action_search_country_to_ticket_list)
        }
        vm.directFlights.observe(viewLifecycleOwner) {
            setupDirect(it)
        }
    }

    private fun setupDirect(directData: List<Flight>) = with(binding.inclDirectCountry) {
        tvTimeDirect1.text = directData[0].timeRange.joinToString(separator = " ")
        tvPriceDirect1.text = getString(R.string.price, directData[0].price.value.formatPrice())
        tvCompanyNameDirect.text = directData[0].title
        tvTimeDirect2.text = directData[1].timeRange.joinToString(separator = " ")
        tvPriceDirect2.text = getString(R.string.price, directData[1].price.value.formatPrice())
        tvCompanyNameDirect2.text = directData[1].title
        tvTimeDirect3.text = directData[2].timeRange.joinToString(separator = " ")
        tvPriceDirect3.text = getString(R.string.price, directData[2].price.value.formatPrice())
        tvCompanyNameDirect3.text = directData[2].title
    }

    private fun setupSearch() = with(binding.inclSearchCountry) {
        tvFromCountry.text = vm.departure.value
        tvToCountry.text = vm.destination.value
        btnBackCountry.setOnClickListener {
            navController.popBackStack()
        }
        btnSwapCountry.setOnClickListener {
            vm.setDeparture(tvToCountry.text as String?)
            vm.setDestination(tvFromCountry.text as String?)
            val temp = tvFromCountry.text
            tvFromCountry.text = tvToCountry.text
            tvToCountry.text = temp
            vm.getDirectFlights()
        }
        btnClearCountry.setOnClickListener {//todo
            vm.setDestination(null)
            navController.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}