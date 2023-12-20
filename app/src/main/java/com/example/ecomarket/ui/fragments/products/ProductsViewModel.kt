package com.example.ecomarket.ui.fragments.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomarket.data.models.Products
import com.example.ecomarket.data.repositories.Repository
import com.example.ecomarket.tools.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    init {
        getProducts()
    }

    private var _productState = MutableStateFlow<UiState<Products>>(UiState.Empty())
    val productState = _productState.asStateFlow()

    private fun getProducts() = viewModelScope.launch {
        repository.getProducts().collect {
            _productState.value = it
        }
    }

}