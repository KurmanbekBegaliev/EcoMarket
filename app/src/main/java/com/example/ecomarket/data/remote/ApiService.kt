package com.example.ecomarket.data.remote

import com.example.ecomarket.data.models.Category
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("product-category-list/")
    suspend fun getProductCategory(): Response<Category>
}