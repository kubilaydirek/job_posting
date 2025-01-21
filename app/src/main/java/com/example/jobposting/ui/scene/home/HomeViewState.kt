package com.example.jobposting.ui.scene.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue

class HomeViewState {
    val searchTextField: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))


}

@Composable
fun rememberHomeViewState(): HomeViewState =
    remember {
        HomeViewState()
    }