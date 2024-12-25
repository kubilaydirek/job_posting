package com.example.jobposting.data.validator

class PasswordValidator : FieldValidator<String> {
    override fun validate(value: String): Boolean {
        return value.length >= 6
    }
}