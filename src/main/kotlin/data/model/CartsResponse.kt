package org.example.data.model

import com.google.gson.annotations.SerializedName

data class CartsResponse(
    @SerializedName("id")
    val cartId: Int,
    val products: List<ProductsResponse>,
    val total: Double
)