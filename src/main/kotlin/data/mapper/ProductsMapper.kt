package org.example.data.mapper

import org.example.data.model.CartsResponse
import org.example.data.model.ProductsResponse
import org.example.domain.model.Carts
import org.example.domain.model.Products

fun ProductsResponse.toProduct() = Products(productId, productTitle, productPrice)
fun List<ProductsResponse>.toProductList() = map { it.toProduct() }


fun CartsResponse.toCartsList(): List<Carts> {
    return listOf(
        Carts(
            id = this.cartId,
            products = this.products.map { it.toProduct() },
            total = this.total
        )
    )
}

fun CartsResponse.toCarts(): Carts {
    return Carts(
        id = this.cartId,
        products = this.products.map { it.toProduct() },
        total = this.total
    )
}

fun List<CartsResponse>.toCartsList(): List<Carts> {
    return map { it.toCarts() }
}


