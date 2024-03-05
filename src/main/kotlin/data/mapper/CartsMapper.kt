package org.example.data.mapper

import org.example.data.model.AllCartsResponse
import org.example.data.model.CartResponse
import org.example.data.model.ProductsResponse
import org.example.data.model.SignInRequest
import org.example.domain.model.Cart
import org.example.domain.model.Products
import org.example.domain.model.SignInModel

fun ProductsResponse.toProduct() = Products(productId, productTitle, productPrice)
//fun List<ProductsResponse>.toProductList() = map { it.toProduct() }

fun CartResponse.toCarts(): Cart {
    return Cart(
        id = this.cartId,
        products = this.products.map { it.toProduct() },
        total = this.total
    )
}

fun List<CartResponse>.toCartsList() =  map { it.toCarts() }

fun AllCartsResponse.toCartsList() = carts.toCartsList()
fun AllCartsResponse.toCarts(): List<Cart> {
    return this.carts.toCartsList()
}






fun SignInModel.toRequest() = SignInRequest(username, password)
