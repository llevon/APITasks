package org.example.data.mapper

import org.example.data.model.CartsResponse
import org.example.data.model.ProductsResponse
import org.example.domain.model.Products

fun ProductsResponse.toProduct() = Products(productId, productTitle, productPrice)
fun List<ProductsResponse>.toProductList() = map { it.toProduct() }

fun CartsResponse.toProductList() = products.toProductList()