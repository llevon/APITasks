package org.example.domain.utils

import java.lang.Exception

sealed class Resource<out T> {
    object Loading: Resource<Nothing>()
    data class Success<T>(val model:T):Resource<T>()
    data class Error(val exception: Exception):Resource<Nothing>()
}