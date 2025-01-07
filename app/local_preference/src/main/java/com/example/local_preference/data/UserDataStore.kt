package com.example.local_preference.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.local_preference.UserPreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) : UserPreference {
    override fun getUserName(): Flow<String> {
        return dataStore.data.catch { emit(emptyPreferences()) }.map { preference ->
            preference[KEYS.KEY_USER_NAME] ?: ""
        }
    }

    override suspend fun saveUserName(name: String) {
        dataStore.edit { preference ->
            preference[KEYS.KEY_USER_NAME] = name
        }
    }

    override fun getToken(): Flow<String> {
        return dataStore.data.catch { emit(emptyPreferences()) }.map { preference ->
            preference[KEYS.TOKEN] ?: ""
        }
    }

    override suspend fun saveToken(token: String) {
        dataStore.edit { preference ->
            preference[KEYS.TOKEN] = token
        }
    }
}

object KEYS {
    val KEY_USER_NAME = stringPreferencesKey("user_name")
    val TOKEN = stringPreferencesKey("token")
}