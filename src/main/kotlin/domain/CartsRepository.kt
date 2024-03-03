package org.example.domain

import org.example.data.model.CartsResponse
import org.example.domain.model.Products

interface CartsRepository {
    suspend fun getCarts(): List<Products>
}