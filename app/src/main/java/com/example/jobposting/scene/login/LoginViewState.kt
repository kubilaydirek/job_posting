package com.example.jobposting.scene.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue

class LoginViewState {
    val username: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val password: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))


}

@Composable
fun rememberLoginViewState(): LoginViewState =
    remember {
        LoginViewState()
    }
