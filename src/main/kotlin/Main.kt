package org.example

import kotlinx.coroutines.runBlocking
import org.example.data.CartsRepositoryImpl
import org.example.domain.model.Products

fun main() {

    val cartsRepository = CartsRepositoryImpl()
    runBlocking {
        try {
            val products: List<Products> = cartsRepository.getCarts()
            println("Received Products: $products")
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
}

