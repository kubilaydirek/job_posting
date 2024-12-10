package com.example.jobposting.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.jobposting.ui.theme.Dark
import com.example.jobposting.ui.theme.White
import com.example.jobposting.ui.theme.customTypography

@Composable
fun JobText(
    modifier: Modifier = Modifier,
    text: String,
    bold: Boolean = false,
    fontSize: TextUnit = 12.sp,
    color: Color = Dark,
) {

    Text(
        text = text,
        modifier = modifier,
        style = customTypography.titleLarge.copy(
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
            fontSize = fontSize,
            color = color,
        )
    )
}

@Preview
@Composable
private fun JobTextPreview() {
    JobText(text = "Text Message", color = White)
}