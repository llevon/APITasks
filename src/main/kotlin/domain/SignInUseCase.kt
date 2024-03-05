package org.example.domain

import kotlinx.coroutines.flow.Flow
import org.example.domain.model.SignInModel
import org.example.domain.utils.Resource

class SignInUseCase(
    private val cartsRepository: CartsRepository
) {
    operator fun invoke (signInModel: SignInModel): Flow<Resource<Unit>>
    {
        return cartsRepository.signIn(signInModel)
    }
}