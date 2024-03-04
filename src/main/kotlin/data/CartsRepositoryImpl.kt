package org.example.data

import okhttp3.OkHttpClient
import org.example.data.api.APIService
import org.example.data.api.BASE_URL
import org.example.data.mapper.toCartsList
import org.example.data.mapper.toProduct
import org.example.data.model.CartsResponse
import org.example.domain.CartsRepository
import org.example.domain.model.Carts
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

    override suspend fun getCarts(id: Int): List<Carts> {
        val response = apiService.getCarts(id)
        return if (response.isSuccessful) {
            val body = response.body()
            body?.let {
                val carts = it.toCartsList()
                carts
            } ?: emptyList()
        } else {
            return emptyList()
        }
    }

    override suspend fun getAllCarts(): List<Carts> {
        val response = apiService.getAllCarts()
        return if (response.isSuccessful) {
            response.body()?.toCartsList() ?: emptyList()
        } else {
            emptyList()
        }
    }

    override suspend fun addCart(id: Int, products: List<Products>, total: Double): CartsResponse? {
        val cart = Carts(id, products, total)
        val response = apiService.addCart(cart)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}


