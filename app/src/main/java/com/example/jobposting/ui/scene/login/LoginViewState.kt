package com.example.jobposting.ui.scene.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue

class LoginViewState {
    val username: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val password: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    var passwordIsError: MutableState<Boolean> = mutableStateOf(false)
    var usernameIsError : MutableState<Boolean> = mutableStateOf(false)

    fun validator(){
        passwordIsError.value = password.value.text.isEmpty()
        usernameIsError.value = username.value.text.isEmpty()
    }
}

@Composable
fun rememberLoginViewState(): LoginViewState =
    remember {
        LoginViewState()
    }
