package com.css101.airtickets.presentation.ui.search

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.css101.airtickets.R
import com.css101.airtickets.databinding.DialogSearchBinding
import com.css101.airtickets.domain.models.SearchMode
import com.css101.airtickets.utils.showKeyboard
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: DialogSearchBinding
    private var mode: SearchMode? = null
    private val vm by viewModel<SearchViewModel>()
    private lateinit var navController: NavController

    companion object {
        fun newInstance(searchMode: SearchMode): SearchDialogFragment {
            return SearchDialogFragment().apply {
                mode = searchMode
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vm.saveMode(mode)
        binding = DialogSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val sheetContainer = requireView().parent as? ViewGroup ?: return
        dialog?.window?.setDimAmount(0.0F)
        sheetContainer.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog
            ?.window
            ?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setupSearch()
        setupRecommendations()
    }

    private fun setupSearch() = with(binding.inclSearchSearch) {
        vm.departure.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                etFrom.setText(it)
            }
        }
        when (vm.mode.value) {
            SearchMode.From -> {
                etFrom.showKeyboard()
            }

            SearchMode.To -> {
                etWhere.showKeyboard()
            }

            else -> {}
        }

        etWhere.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH) {
                navController.navigate(R.id.action_search_to_search_country)
                true
            } else {
                false
            }
        }
    }

    private fun setupRecommendations() = with(binding.inclRecommendationsSearch) {
        clPhuket.setOnClickListener {
            binding.inclSearchSearch.etWhere.setText(getString(R.string.phuket))
            navController.navigate(R.id.action_search_to_search_country)
            vm.saveToCity("Пхукет")
        }
        clSochi.setOnClickListener {
            binding.inclSearchSearch.etWhere.setText(getString(R.string.sochi))
            navController.navigate(R.id.action_search_to_search_country)
            vm.saveToCity("Сочи")

        }
        clIstanbul.setOnClickListener {
            binding.inclSearchSearch.etWhere.setText(getString(R.string.istambul))
            navController.navigate(R.id.action_search_to_search_country)
            vm.saveToCity("Стамбул")

        }
    }
}