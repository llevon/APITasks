package org.example

import kotlinx.coroutines.runBlocking
import org.example.data.CartsRepositoryImpl
import org.example.domain.model.Carts
import org.example.domain.model.Products

fun main() {

    val cartsRepository = CartsRepositoryImpl()
    runBlocking {
        try {
            //val carts = cartsRepository.getCarts()
            //val carts1 = cartsRepository.getAllCarts()
            //println(carts)
            //println(carts1)
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }

        val product1 = Products(1, "Product1", 10.0)
        val product2 = Products(2, "Product2", 15.0)
        val cartId = 1
        val products = listOf(product1, product2)
        val total = product1.productPrice + product2.productPrice
        val addedCart = cartsRepository.addCart(cartId, products, total)
        if (addedCart != null) {
            println("Cart added successfully: $addedCart")
        } else {
            println("Failed to add cart.")
        }

    }

}

