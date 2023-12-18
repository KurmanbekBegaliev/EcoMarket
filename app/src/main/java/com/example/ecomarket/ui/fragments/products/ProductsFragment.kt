package com.example.ecomarket.ui.fragments.products

import androidx.fragment.app.viewModels
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentPorductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentPorductsBinding, ProductsViewModel>() {
    override fun getViewBinding() = FragmentPorductsBinding.inflate(layoutInflater)
    override val viewModel: ProductsViewModel by viewModels()

    override fun initialize() {

    }

}