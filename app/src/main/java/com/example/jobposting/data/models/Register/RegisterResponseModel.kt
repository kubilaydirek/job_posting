package com.example.jobposting.data.models.Register

data class RegisterResponseModel(
    val login: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)
