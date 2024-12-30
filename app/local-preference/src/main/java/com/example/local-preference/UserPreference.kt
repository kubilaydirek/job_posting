package com.example.`local-preference`

import kotlinx.coroutines.flow.Flow

interface UserPreference {
    fun userName(): Flow<String>
    suspend fun saveUsername(name: String)
}