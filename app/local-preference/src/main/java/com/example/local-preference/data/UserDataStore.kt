package com.example.`local-preference`.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.`local-preference`.UserPreference
import com.example.`local-preference`.data.KEYS.KEY_USER_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) : UserPreference {
    override fun userName(): Flow<String> {
        return dataStore.data
            .catch { emit(emptyPreferences()) }
            .map { preference ->
                preference[KEY_USER_NAME] ?: ""
            }
    }

    override suspend fun saveUsername(name: String) {
        dataStore.edit { preference ->
            preference[KEY_USER_NAME] = name
        }
    }

}


object KEYS {
    val KEY_USER_NAME = stringPreferencesKey("user_name")
}