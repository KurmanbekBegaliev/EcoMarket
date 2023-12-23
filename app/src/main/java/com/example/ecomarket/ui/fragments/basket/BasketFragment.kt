package com.example.ecomarket.ui.fragments.basket


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ecomarket.R
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentBasketBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment : BaseFragment<FragmentBasketBinding, BasketViewModel>() {
    override fun getViewBinding(): FragmentBasketBinding = FragmentBasketBinding.inflate(layoutInflater)

    override val viewModel: BasketViewModel by viewModels()
    override fun initialize() {
        binding.btnDoDelivery.setOnClickListener {
            findNavController().navigate(R.id.orderFragment)
        }
    }

}