package com.example.jobposting.data.validator

interface FieldValidator<T> {
    fun validate(value: T): Boolean
}