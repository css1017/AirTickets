package com.css101.airtickets.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.css101.airtickets.databinding.DialogSearchBinding
import com.css101.airtickets.models.SearchMode
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SearchDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: DialogSearchBinding
    private var mode: SearchMode? = null
    //private val vm by viewModel<SearchViewModel>()


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
        binding = DialogSearchBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
    }

}