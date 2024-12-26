package com.example.jobposting.data.models

data class ExceptionModel(
    val detail: String,
    val instance: String,
    val message: String,
    val params: String,
    val path: String,
    val status: Int,
    val title: String,
    val type: String
)