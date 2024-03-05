package org.example.data.api

import org.example.data.model.AllCartsResponse
import org.example.data.model.CartResponse
import org.example.data.model.SignInRequest
import org.example.data.model.SignInResponse
import org.example.domain.model.Cart
import org.example.domain.model.SignInModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService{
    @GET(GET_ALL_CARTS)
    suspend fun getAllCarts(): Response<AllCartsResponse>
    /*@GET(GET_CART_BY_ID)
    suspend fun getCarts(@Path("id") id:Int): Response<CartResponse>*/


    @POST("login")
    suspend fun signIn(@Body signInRequest: SignInRequest):Response<SignInResponse>

}
