package com.example.ecomarket.ui.fragments.info

import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : BaseFragment<FragmentInfoBinding, InfoViewModel>() {

    override fun getViewBinding(): FragmentInfoBinding = FragmentInfoBinding.inflate(layoutInflater)

    override val viewModel: InfoViewModel
        get() = TODO("Not yet implemented")

}