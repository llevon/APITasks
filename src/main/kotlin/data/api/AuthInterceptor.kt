package org.example.data.api

import okhttp3.Interceptor
import okhttp3.Response
import org.example.data.local.TokenDataSource

class AuthInterceptor(private val tokenDataSource: TokenDataSource) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header("Authorization","Bearer ${tokenDataSource.getToken()}")
            .build()
        return chain.proceed(request)
    }
}