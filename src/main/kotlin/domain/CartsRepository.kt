package org.example.domain

import kotlinx.coroutines.flow.Flow
import org.example.data.model.CartResponse
import org.example.domain.model.Cart
import org.example.domain.model.Products
import org.example.domain.model.SignInModel
import org.example.domain.utils.Resource


interface CartsRepository {
    //suspend fun getCart(id: Int): Cart?
    fun getAllCarts(): Flow<Resource<List<Cart>>>
    fun signIn(signInModel: SignInModel): Flow<Resource<Unit>>

}