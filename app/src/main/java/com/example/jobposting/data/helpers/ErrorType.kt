package com.example.jobposting.data.helpers

sealed class ErrorType {
    sealed class Api : ErrorType() {
        data object Network : Api()
        data object ServiceUnavailable : Api()
        data object NotFount : Api()
        data object Server : Api()
        data object Unauthorized : Api()
        data class UnknownBackend (val errorText : String) : Api()
    }
    data object Unknown : ErrorType()
}