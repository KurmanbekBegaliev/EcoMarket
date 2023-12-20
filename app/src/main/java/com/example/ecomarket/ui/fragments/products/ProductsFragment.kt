package com.example.ecomarket.ui.fragments.products

import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecomarket.R
import com.example.ecomarket.base.BaseFragment
import com.example.ecomarket.data.models.ProductsItem
import com.example.ecomarket.databinding.FragmentPorductsBinding
import com.example.ecomarket.tools.UiState
import com.example.ecomarket.tools.showToast
import com.example.ecomarket.tools.viewVisibility
import com.example.ecomarket.ui.fragments.products.adapters.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentPorductsBinding, ProductsViewModel>() {
    override fun getViewBinding() = FragmentPorductsBinding.inflate(layoutInflater)
    override val viewModel: ProductsViewModel by viewModels()
    private lateinit var adapter: ProductsAdapter
    private var id: Int? = null

    override fun initialize() {
        id = arguments?.getInt("category_key")
        adapter = ProductsAdapter(this::onClick)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter

        binding.tvCancel.setOnClickListener {
            it.viewVisibility(false)
        }
    }

    override fun setupSubscribes() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.productState.collect {
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
//                            it.data?.let { it1 -> adapter.updateList(it1) }
                            val list = it.data as List<ProductsItem>

                            val sortedList = list as MutableList<ProductsItem>
                            binding.edtSearch.addTextChangedListener(object : TextWatcher {
                                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                                override fun afterTextChanged(p0: Editable?) {}

                                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                                    sortedList.clear()
                                    for (i in list) {
                                        if (p0?.length != 0 && i.title.toString().contains(p0.toString(), true)) sortedList.add(i)
                                    }
                                    if (p0?.length != 0) adapter.updateList(id?.let { it1 -> sortList(it1, sortedList) } ?: sortedList)
                                    else adapter.updateList(id?.let { it1 -> sortList(it1, list) } ?: list)
                                }

                            })

                            binding.chipsGroup.check(checkChip(id))
                            adapter.updateList(id?.let { it1 -> sortList(it1, list) } ?: list)

                            binding.chipsGroup.setOnCheckedChangeListener { _, checkedId ->
                                when (checkedId) {
                                    binding.chip0.id -> {
                                        showToast("Все")
                                        adapter.updateList(sortedList)
                                        id = 7
                                    }

                                    binding.chip1.id -> {
                                        adapter.updateList(sortList(1, list))
                                        id = 1
                                    }

                                    binding.chip2.id -> {
                                        showToast("Сухофрукты")
                                        adapter.updateList(sortList(2, list))
                                        id = 2
                                    }

                                    binding.chip3.id -> {
                                        adapter.updateList(sortList(3, list))
                                        id = 3
                                    }

                                    binding.chip4.id -> {
                                        adapter.updateList(sortList(4, list))
                                        id = 4
                                    }

                                    binding.chip5.id -> {
                                        adapter.updateList(sortList(5, list))
                                        id = 5
                                    }

                                    binding.chip6.id -> {
                                        adapter.updateList(sortList(6, list))
                                        id = 6
                                    }

                                    else -> {}

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun searchList(list: List<ProductsItem>, update: (List<ProductsItem>) -> Unit) {
        val sortedList = mutableListOf<ProductsItem>()

        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                sortedList.clear()
                for (i in list) {
                    if (p0?.length != 0 && i.title.toString().contains(p0.toString())) sortedList.add(i)
                }
                update(sortedList)
            }
        })


    }

    private fun onClick() {

    }

    private fun checkChip(id: Int?): Int {
        return when (id) {
            1 -> R.id.chip_1
            2 -> R.id.chip_2
            3 -> R.id.chip_3
            4 -> R.id.chip_4
            5 -> R.id.chip_5
            6 -> R.id.chip_6
            7 -> R.id.chip_0
            else -> R.id.chip_0
        }
    }

    private fun sortList(cat: Int, list: List<ProductsItem>): List<ProductsItem> {
        val sortedList = mutableListOf<ProductsItem>()
        for (i in list) {
            if (i.category == cat) sortedList.add(i)
        }
        return sortedList
    }

}