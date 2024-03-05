package org.example.data
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import org.example.data.api.APIService
import org.example.data.local.TokenDataSource
import org.example.data.mapper.toCarts
import org.example.data.mapper.toCartsList
import org.example.data.mapper.toRequest
import org.example.data.model.CartResponse
import org.example.di.AppComponent
import org.example.domain.CartsRepository
import org.example.domain.model.Cart
import org.example.domain.model.Products
import org.example.domain.model.SignInModel
import org.example.domain.utils.Resource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CartsRepositoryImpl
    (
            private val apiService: APIService,
            private val tokenDataSource: TokenDataSource
            ): CartsRepository {

   /* override suspend fun getCart(id: Int): Cart? {
        val response = apiService.getCarts(id)
        return if (response.isSuccessful) {
            val body = response.body()
            body?.let {
                val carts = it.toCarts()
                carts
            }
        } else {
            return null
        }
    }*/

    override fun getAllCarts(): Flow<Resource<List<Cart>>> {
        return flow {
            emit(Resource.Loading)
            val response = apiService.getAllCarts()
            try {
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.Success(it.toCartsList()))
                    }
                } else emit(Resource.Error(Exception("Invalid data or unknown error")))
            } catch (e: Exception) {
                emit(Resource.Error(Exception("Invalid data or unknown error")))
            }
        }
    }

    override fun signIn(signInModel: SignInModel): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading)
            val response = apiService.signIn(signInModel.toRequest())
            try {
                if (response.isSuccessful) {
                    response.body()?.let {
                        val token = it.token
                        tokenDataSource.setToken(token)
                        emit(Resource.Success(Unit))
                    }
                } else emit(Resource.Error(Exception("Invalid data or unknown error")))
            } catch (e: Exception) {
                emit(Resource.Error(Exception("Invalid data or unknown error")))
            }
        }
    }
}



