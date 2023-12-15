package com.example.ecomarket.ui.fragments.story

import androidx.fragment.app.Fragment
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentStoryBinding


class StoryFragment : BaseFragment<FragmentStoryBinding, StoryViewModel>() {
    override fun getViewBinding(): FragmentStoryBinding = FragmentStoryBinding.inflate(layoutInflater)

    override val viewModel: StoryViewModel
        get() = TODO("Not yet implemented")

}