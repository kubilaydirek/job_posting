package com.example.jobposting.data.di

import com.example.jobposting.data.helpers.ErrorTypeToErrorTextConverter
import com.example.jobposting.data.helpers.ErrorTypeToErrorTextConverterImp
import com.example.jobposting.data.repository.AuthRepository
import com.example.jobposting.data.repository.AuthRepositoryImp
import com.example.jobposting.data.repository.HomeRepository
import com.example.jobposting.data.repository.HomeRepositoryImp
import com.example.jobposting.data.service.AuthApiService
import com.example.jobposting.data.service.HomeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideAuthRepository(service: AuthApiService): AuthRepository {
        return AuthRepositoryImp(service)
    }

    @Singleton
    @Provides
    fun provideErrorTypeConverter(): ErrorTypeToErrorTextConverter {
        return ErrorTypeToErrorTextConverterImp()
    }

    @Singleton
    @Provides
    fun provideHomeRepository(service: HomeApiService): HomeRepository {
        return HomeRepositoryImp(service)
    }
}