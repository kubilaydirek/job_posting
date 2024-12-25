package com.example.jobposting.data.helpers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.example.jobposting.ui.theme.Error
import com.example.jobposting.ui.theme.Success
import com.example.jobposting.ui.theme.Warning

enum class ToastMessageType {
    ERROR,
    SUCCESS,
    WARNING,
    ;

    val color: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            ERROR -> Error
            SUCCESS -> Success
            WARNING -> Warning
        }
}