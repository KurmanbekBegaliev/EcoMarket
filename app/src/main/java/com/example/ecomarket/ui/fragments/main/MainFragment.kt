package com.example.ecomarket.ui.fragments.main

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecomarket.R
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.databinding.FragmentMainBinding
import com.example.ecomarket.tools.UiState
import com.example.ecomarket.tools.showToast
import com.example.ecomarket.tools.viewVisibility
import com.example.ecomarket.ui.fragments.main.adapters.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override fun getViewBinding(): FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)

    override val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: CategoryAdapter

    override fun initialize() {
        adapter = CategoryAdapter(this::onClick)
        binding.rvCategory.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCategory.adapter = adapter
        viewModel.getCategories()
    }

    private fun onClick(id: String) {
        showToast(id)
        findNavController().navigate(R.id.productsFragment)
    }

    override fun setupSubscribes() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categoryState.collect{
                    when (it) {
                        is UiState.Empty -> {}
                        is UiState.Error -> {
                            binding.progressBar.viewVisibility(false)
                            showToast(it.msg)
                        }
                        is UiState.Loading -> {
                            binding.progressBar.viewVisibility(true)
                        }
                        is UiState.Success -> {
                            binding.progressBar.viewVisibility(false)
                            it.data?.let { it1 -> adapter.updateList(it1) }
                        }
                    }
                }
            }
        }
    }

}