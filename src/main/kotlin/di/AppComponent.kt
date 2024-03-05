package org.example.di

import okhttp3.OkHttpClient
import org.example.data.CartsRepositoryImpl
import org.example.data.api.APIService
import org.example.data.api.AuthInterceptor
import org.example.data.api.BASE_URL
import org.example.data.local.TokenDataSource
import org.example.domain.CartsRepository
import org.example.domain.GetCartsUseCase
import org.example.domain.SignInUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.prefs.Preferences

object AppComponent {
    private val tokenDataSource = TokenDataSource()

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(tokenDataSource))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    private val apiService = retrofit.create<APIService>()

    private val repository: CartsRepository = CartsRepositoryImpl(apiService, tokenDataSource)

    val signInUseCase = SignInUseCase(repository)
    val getCartsUseCase = GetCartsUseCase(repository)
}