package com.example.jobposting.ui.component.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jobposting.data.helpers.ToastMessageType
import com.example.jobposting.data.helpers.UiState
import com.example.jobposting.ui.component.progressIndicator.JobProgressIndicator
import com.example.jobposting.ui.component.toastMessage.JobToastMessage

@Composable
fun JobScaffold(
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit,
    uiState: UiState = UiState.Empty,
    bottomBar: @Composable () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.imePadding(),
        topBar = {},
        content = {
            when (uiState) {
                is UiState.Empty -> {
                    content.invoke(it)
                }

                is UiState.Loading -> {
                    content.invoke(it)
                    JobProgressIndicator()
                }

                is UiState.Success<*> -> {
                    content.invoke(it)
                    if (uiState.showToast) {
                        JobToastMessage(
                            modifier,
                            isVisible = uiState.showToast,
                            message = uiState.message,
                            toastType = ToastMessageType.SUCCESS
                        )
                    }
                }

                is UiState.Error -> {
                    content.invoke(it)
                    if (uiState.showToast) {
                        JobToastMessage(
                            modifier,
                            isVisible = uiState.showToast,
                            message = uiState.error.asString(),
                            toastType = ToastMessageType.ERROR
                        )
                    }
                }
            }
        },
        bottomBar = bottomBar
    )
}