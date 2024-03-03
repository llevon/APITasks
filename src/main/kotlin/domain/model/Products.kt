package org.example.domain.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("id")
    val productId: Int,
    @SerializedName("title")
    val productTitle: String,
    @SerializedName("price")
    val productPrice: Double
)
