package org.example.data.api

import org.example.data.model.CartsResponse
import org.example.domain.model.Carts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService{
    @GET(GET_ALL_CARTS)
    suspend fun getAllCarts(): Response<List<CartsResponse>>
    @GET(GET_PRODUCT_BY_ID)
    suspend fun getCarts(@Path("id") id:Int): Response<CartsResponse>

    @GET(GET_PRODUCT_SINGLE)
    suspend fun getCarts(): Response<CartsResponse>

    @POST(ADD_CART)
    suspend fun addCart(cart: Carts): Response<CartsResponse>}