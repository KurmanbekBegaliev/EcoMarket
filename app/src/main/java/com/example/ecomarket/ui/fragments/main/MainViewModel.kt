package com.example.ecomarket.ui.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomarket.data.models.Category
import com.example.ecomarket.data.repositories.Repository
import com.example.ecomarket.tools.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _categoryState = MutableStateFlow<UiState<Category>>(UiState.Empty())
    val categoryState = _categoryState.asStateFlow()

    fun getCategories() = viewModelScope.launch {
        repository.getCategories().collect {
            _categoryState.value = it
        }
    }

}