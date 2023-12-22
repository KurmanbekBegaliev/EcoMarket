package com.example.ecomarket.ui.fragments.products

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecomarket.data.models.ProductsItem
import com.example.ecomarket.databinding.FragmentProductDescriptionBinding
import com.example.ecomarket.tools.setImage
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProductDescriptionFragment(
    private val item: ProductsItem
) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentProductDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDescriptionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =
            BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener { itDialog ->
            val bottomSheetDialog = itDialog as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let {
                val behaviour = BottomSheetBehavior.from(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
            initialize()
        }
        return dialog
    }

    private fun initialize() {
        binding.apply {
            tvTitleProduct.text = item.title
            tvDesc.text = item.description
            tvPrice.text = item.price
            imgProduct.setImage(item.image)
        }
    }

}