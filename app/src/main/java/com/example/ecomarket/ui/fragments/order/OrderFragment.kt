package com.example.ecomarket.ui.fragments.order

import androidx.fragment.app.viewModels
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentOrderBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OrderFragment : BaseFragment<FragmentOrderBinding, OrderViewModel>() {
    override fun getViewBinding(): FragmentOrderBinding =
        FragmentOrderBinding.inflate(layoutInflater)

    override val viewModel: OrderViewModel by viewModels()

    override fun initialize() {

    }
}