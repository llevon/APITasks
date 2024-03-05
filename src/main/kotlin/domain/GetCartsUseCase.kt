package org.example.domain

import kotlinx.coroutines.flow.Flow
import org.example.domain.model.Cart
import org.example.domain.utils.Resource

class GetCartsUseCase(
    private val repository: CartsRepository
) {
    operator fun invoke (): Flow<Resource<List<Cart>>>{
        return repository.getAllCarts()
    }
}