package org.example.data

import okhttp3.OkHttpClient
import org.example.data.api.APIService
import org.example.data.api.BASE_URL
import org.example.data.mapper.toProductList
import org.example.data.model.CartsResponse
import org.example.domain.CartsRepository
import org.example.domain.model.Products
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CartsRepositoryImpl : CartsRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()

    private val apiService = retrofit.create<APIService>()
    override suspend fun getCarts(): List<Products> {
        val response = apiService.getCarts()
        return if (response.isSuccessful) {
            val body = response.body()
            body?.let {
                val carts = it.toProductList()
                carts
            } ?: emptyList()
        } else {
            return emptyList()
        }
    }
    }
