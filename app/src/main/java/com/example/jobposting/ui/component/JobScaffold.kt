package com.example.jobposting.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JobScaffold(modifier: Modifier = Modifier, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        modifier = modifier.imePadding(),
        topBar = {},
        content = {
            content.invoke(it)
        },
    )
}