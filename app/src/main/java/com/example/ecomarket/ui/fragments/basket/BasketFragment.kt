package com.example.ecomarket.ui.fragments.basket


import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentBasketBinding

class BasketFragment : BaseFragment<FragmentBasketBinding, BasketViewModel>() {
    override fun getViewBinding(): FragmentBasketBinding = FragmentBasketBinding.inflate(layoutInflater)

    override val viewModel: BasketViewModel
        get() = TODO("Not yet implemented")

}