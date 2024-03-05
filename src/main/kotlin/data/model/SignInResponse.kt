package org.example.data.model

import java.nio.file.attribute.UserPrincipal

data class SignInResponse(
    val id:Int,
    val username: String,
    val token: String
)
