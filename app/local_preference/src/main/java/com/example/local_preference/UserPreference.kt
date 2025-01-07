package com.example.local_preference

import kotlinx.coroutines.flow.Flow

interface UserPreference {
    fun getUserName(): Flow<String>

    suspend fun saveUserName(name: String)

    fun getToken(): Flow<String>

    suspend fun saveToken(token: String)
}