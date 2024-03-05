package org.example

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.example.di.AppComponent
import org.example.domain.model.SignInModel
import org.example.domain.utils.Resource

fun main() {
    val coroutineScope = CoroutineScope(CoroutineName("my_coroutine"))
    val signInUseCase = AppComponent.signInUseCase
    val getCartsUseCase = AppComponent.getCartsUseCase
    val signInModel = SignInModel(username ="kminchelle" , password = "0lelplR")
    signInUseCase(signInModel)
        .flowOn(Dispatchers.IO)
        .onEach {
            signInState->
            when(signInState)
            {
                Resource.Loading -> println("is Loading")
                is Resource.Error -> println(signInState.exception.message)
                is Resource.Success -> {
                    println("success")
                    getCartsUseCase()
                        .flowOn(Dispatchers.IO)
                        .onEach {
                            getCartsState ->
                            when(getCartsState) {
                                Resource.Loading -> println("loading carts")
                                is Resource.Error -> println(getCartsState.exception.message)
                                is Resource.Success -> println(getCartsState.model)
                            }
                        }
                        .flowOn(Dispatchers.Unconfined)
                        .launchIn(coroutineScope)
                }
            }
        }
        .flowOn(Dispatchers.Unconfined)
        .launchIn(coroutineScope)

    Thread.sleep(5000)
}

