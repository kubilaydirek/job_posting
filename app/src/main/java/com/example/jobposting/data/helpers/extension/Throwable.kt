package com.example.jobposting.data.helpers.extension

import com.example.jobposting.data.helpers.ErrorCodes
import com.example.jobposting.data.helpers.ErrorType
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toErrorType() = when (this) {
    is IOException -> ErrorType.Api.Network
    is HttpException -> when (code()) {
        ErrorCodes.Http.ResourceNotFound -> ErrorType.Api.NotFount
        ErrorCodes.Http.Unauthorized -> ErrorType.Api.Unauthorized
        ErrorCodes.Http.ServiceUnavaible -> ErrorType.Api.ServiceUnavailable
        ErrorCodes.Http.InternalServer -> ErrorType.Api.Server
        else -> ErrorType.Unknown
    }

    else -> ErrorType.Unknown
}