package com.example.jobposting.data.helpers

import com.example.jobposting.R

interface ErrorTypeToErrorTextConverter {
    fun convert(errorType: ErrorType): ErrorText
}

class ErrorTypeToErrorTextConverterImp : ErrorTypeToErrorTextConverter {
    override fun convert(errorType: ErrorType) = when (errorType) {
        ErrorType.Api.NotFount -> ErrorText.StringResource(R.string.error_resource_not_found)
        ErrorType.Api.ServiceUnavailable -> ErrorText.StringResource(R.string.error_service_unavailable)
        ErrorType.Api.Server -> ErrorText.StringResource(R.string.error_server)
        ErrorType.Api.Network -> ErrorText.StringResource(R.string.error_network_unavailable)
        ErrorType.Api.Unauthorized -> ErrorText.StringResource(R.string.unauthorized)
        ErrorType.Unknown -> ErrorText.StringResource(R.string.error_general)
        is ErrorType.Api.UnknownBackend -> ErrorText.ApiErrorText(errorType.errorText)
    }

}
