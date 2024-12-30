package com.example.`local-preference`.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.`local-preference`.UserPreference
import com.example.`local-preference`.data.UserDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object UserPreferenceModule {
    @Provides
    fun userPreferenceModule(dataStore: DataStore<Preferences>): UserPreference {
        return UserDataStore(dataStore)
    }
}