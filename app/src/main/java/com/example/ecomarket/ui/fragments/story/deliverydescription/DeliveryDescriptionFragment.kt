package com.example.ecomarket.ui.fragments.story.deliverydescription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ecomarket.R
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentDeliveryDescriptionBinding
import com.example.ecomarket.ui.fragments.story.adapter.StoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeliveryDescriptionFragment :
    BaseFragment<FragmentDeliveryDescriptionBinding, StoryViewModel>() {
    override fun getViewBinding(): FragmentDeliveryDescriptionBinding =
        FragmentDeliveryDescriptionBinding.inflate(layoutInflater)

    override val viewModel: StoryViewModel by viewModels()

}