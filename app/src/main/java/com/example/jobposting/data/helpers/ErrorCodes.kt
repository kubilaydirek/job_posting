package com.example.jobposting.data.helpers

object ErrorCodes{
    object Http{
        const val InternalServer = 501
        const val ServiceUnavaible = 503
        const val ResourceNotFound = 404
        const val Unauthorized = 401
        const val BadRequest = 400
    }
}