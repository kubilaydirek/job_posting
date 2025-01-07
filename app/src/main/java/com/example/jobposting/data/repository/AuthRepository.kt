package com.example.jobposting.data.repository

import com.example.jobposting.data.helpers.Resource
import com.example.jobposting.data.models.Login.LoginRequestModel
import com.example.jobposting.data.models.Login.LoginResponseModel
import com.example.jobposting.data.models.Register.RegisterRequestModel
import com.example.jobposting.data.models.Register.RegisterResponseModel
import com.example.jobposting.data.service.AuthApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AuthRepository {
    suspend fun login(request: LoginRequestModel): Flow<Resource<LoginResponseModel>>
    suspend fun register(request: RegisterRequestModel): Flow<Resource<RegisterResponseModel>>
}

class AuthRepositoryImp @Inject constructor(private val service: AuthApiService) : AuthRepository {
    override suspend fun login(request: LoginRequestModel): Flow<Resource<LoginResponseModel>> =
        flow {
            emit(Resource.Success(service.login(request)))
        }

    override suspend fun register(request: RegisterRequestModel): Flow<Resource<RegisterResponseModel>> =
        flow {
            emit(Resource.Success(service.register(request)))
        }
}


