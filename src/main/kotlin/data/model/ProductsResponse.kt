package org.example.data.model

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("id")
    val productId: Int,
    @SerializedName("title")
    val productTitle: String,
    @SerializedName("price")
    val productPrice: Double
)
