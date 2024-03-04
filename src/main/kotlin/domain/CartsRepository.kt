package org.example.domain

import org.example.data.model.CartsResponse
import org.example.domain.model.Carts
import org.example.domain.model.Products

interface CartsRepository {
    suspend fun getCarts(id: Int): List<Carts>
    suspend fun getAllCarts(): List<Carts>
    suspend fun addCart(id: Int, products: List<Products>, total: Double): CartsResponse?

}