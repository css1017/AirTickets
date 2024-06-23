package com.css101.airtickets.presentation.ui.hot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.css101.airtickets.databinding.FragmentHotBinding

class HotFragment : Fragment() {

    private var _binding: FragmentHotBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotBinding.inflate(inflater, container, false)
        navController = findNavController()

        binding.btnBackHot.setOnClickListener {
            navController.popBackStack()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}