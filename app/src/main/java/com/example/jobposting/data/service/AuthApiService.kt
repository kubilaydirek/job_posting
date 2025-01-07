package com.example.jobposting.data.service

import com.example.jobposting.data.models.Login.LoginRequestModel
import com.example.jobposting.data.models.Login.LoginResponseModel
import com.example.jobposting.data.models.Register.RegisterRequestModel
import com.example.jobposting.data.models.Register.RegisterResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("authenticate")
    suspend fun login(@Body request: LoginRequestModel): LoginResponseModel

    @POST("register")
    suspend fun register(@Body request: RegisterRequestModel): RegisterResponseModel
}