package com.example.ecomarket.ui.fragments.main

import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override fun getViewBinding(): FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)

    override val viewModel: MainViewModel
        get() = TODO("Not yet implemented")

}