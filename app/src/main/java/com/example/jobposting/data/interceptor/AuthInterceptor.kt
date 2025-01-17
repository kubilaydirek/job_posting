package com.example.jobposting.data.interceptor

import com.example.local_preference.UserPreference
import com.example.local_preference.data.KEYS
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val userPreference: UserPreference) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        val token = runBlocking {
            userPreference.getData<String>(KEYS.TOKEN).firstOrNull()
        }

        if (!token.isNullOrBlank()) {
            request.addHeader("Authorization", "Bearer $token")
        }
        return chain.proceed(request.build())
    }
}