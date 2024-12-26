package com.example.jobposting.ui.scene.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.example.jobposting.data.validator.EmailValidator
import com.example.jobposting.data.validator.PasswordValidator

class LoginViewState {
    val username: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val password: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    var passwordIsError: MutableState<Boolean> = mutableStateOf(false)
    var usernameIsError: MutableState<Boolean> = mutableStateOf(false)

    fun inputsValidator(): Boolean {
        usernameIsError.value = username.value.text.let { EmailValidator().validate(it) }
        passwordIsError.value = password.value.text.let { PasswordValidator().validate(it) }
        return (usernameIsError.value && passwordIsError.value)
    }
}

@Composable
fun rememberLoginViewState(): LoginViewState =
    remember {
        LoginViewState()
    }
