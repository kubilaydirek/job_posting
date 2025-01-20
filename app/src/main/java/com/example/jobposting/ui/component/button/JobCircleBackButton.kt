package com.example.jobposting.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jobposting.ui.theme.Dark
import com.example.jobposting.ui.theme.DarkGrey

@Composable
fun JobCircleBackButton(modifier: Modifier = Modifier, onClick: () -> Unit, size: Dp = 50.dp) {
    Box(
        modifier = modifier
            .size(size)
            .border(1.dp, DarkGrey, CircleShape)
            .padding(1.dp)
            .clip(CircleShape)
            .background(Color.Transparent)
            .clickable { onClick.invoke() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = null,
            modifier = modifier.size(30.dp)
        )
    }
}

@Preview
@Composable
private fun JobCircleBackButtonPreview() {
    JobCircleBackButton(onClick = {})
}