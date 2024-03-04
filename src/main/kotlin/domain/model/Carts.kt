package org.example.domain.model

data class Carts(
    val id: Int,
    val products: List<Products>,
    val total: Double
)