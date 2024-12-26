package com.example.jobposting.data.helpers.extension

import com.example.jobposting.data.helpers.ErrorCodes
import com.example.jobposting.data.helpers.ErrorType
import com.example.jobposting.data.models.ExceptionModel
import com.google.gson.Gson
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

fun Throwable.toErrorType() = when (this) {
    is IOException -> ErrorType.Api.Network
    is HttpException -> when (code()) {
        ErrorCodes.Http.ResourceNotFound -> ErrorType.Api.NotFount
        ErrorCodes.Http.Unauthorized -> ErrorType.Api.Unauthorized
        ErrorCodes.Http.ServiceUnavaible -> ErrorType.Api.ServiceUnavailable
        ErrorCodes.Http.InternalServer -> ErrorType.Api.Server
        else -> ErrorType.Api.UnknownBackend(handleException(this.response()))
    }

    else -> ErrorType.Unknown
}

fun handleException(response: Response<*>?): String {
    response.let {
        val responseError = Gson().fromJson(response?.errorBody()?.string(), ExceptionModel::class.java)
        return responseError.detail
    }
}