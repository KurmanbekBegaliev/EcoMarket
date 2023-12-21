package com.example.ecomarket.ui.fragments.products

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecomarket.R
import com.example.ecomarket.databinding.FragmentProductDescriptionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProductDescriptionFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentProductDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDescriptionBinding.inflate(layoutInflater)
        return binding.root
    }

}