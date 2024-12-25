package com.example.jobposting.data.models.Register

data class RegisterRequestModel(
    val login: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)
