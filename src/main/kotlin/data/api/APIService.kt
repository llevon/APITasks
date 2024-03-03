package org.example.data.api

import org.example.data.model.CartsResponse
import retrofit2.Response
import retrofit2.http.GET
interface APIService{
    @GET(BASE_URL)
    suspend fun getCarts(): Response<CartsResponse>
}