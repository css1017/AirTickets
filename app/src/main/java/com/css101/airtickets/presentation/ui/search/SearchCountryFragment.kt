package com.css101.airtickets.presentation.ui.search

import android.app.DatePickerDialog
import android.icu.util.Calendar
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
import com.css101.airtickets.utils.formatShort
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
        setupSearchTools()
        btnShowAllTickets.setOnClickListener {
            navController.navigate(R.id.action_search_country_to_ticket_list)
        }
        vm.directFlights.observe(viewLifecycleOwner) {
            setupDirect(it)
        }
    }

    private fun setupDirect(directData: List<Flight>) = with(binding.inclDirectCountry) {
        if (directData.isEmpty()){
            binding.inclDirectCountry.root.visibility = View.GONE
        } else {
            binding.inclDirectCountry.root.visibility = View.VISIBLE
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
    }

    private fun setupSearchTools() = with(binding.inclSearchToolsCountry) {
        vm.date.observe(viewLifecycleOwner) {
            btnDateCountry.text = it.formatShort()
        }
        btnDateCountry.setOnClickListener {
            showFlightDatePickerDialog()
        }
        btnReturnCountry.setOnClickListener {
            showReturnDatePickerDialog()
        }
    }

    private fun showFlightDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, month, dayOfMonth)
                vm.saveDate(selectedCalendar.time)
                binding.inclSearchToolsCountry.btnDateCountry.text =
                    selectedCalendar.time.formatShort()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
    private fun showReturnDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, _, _, _ -> },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
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
        btnClearCountry.setOnClickListener {
            vm.setDestination(null)
            navController.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        vm.updateDate()
    }
}