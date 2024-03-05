package org.example.domain.model

data class Cart(
    val id: Int,
    val products: List<Products>,
    val total: Double
)