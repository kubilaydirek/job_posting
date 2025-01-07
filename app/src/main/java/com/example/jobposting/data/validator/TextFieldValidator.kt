package com.example.jobposting.data.validator

class TextFieldValidator : FieldValidator<String> {
    override fun validate(value: String): Boolean {
        return value.isEmpty()
    }
}