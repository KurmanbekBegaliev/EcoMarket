package com.example.ecomarket.data.repositories

import com.example.ecomarket.data.remote.ApiService
import com.example.ecomarket.tools.UiState
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCategories() = flow {
        emit(UiState.Loading())
        val response = apiService.getProductCategory()
        if (response.isSuccessful){
            emit(UiState.Success(response.body()))
        } else {
            emit(UiState.Error(response.message()))
        }
    }

    suspend fun getProducts() = flow {
        emit(UiState.Loading())
        val response = apiService.getProducts()
        if (response.isSuccessful){
            emit(UiState.Success(response.body()))
        } else {
            emit(UiState.Error(response.message()))
        }
    }

}