package com.example.jobposting.ui.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.jobposting.ui.theme.Dark
import com.example.jobposting.ui.theme.White
import com.example.jobposting.ui.theme.customTypography

@Composable
fun JobText(
    modifier: Modifier = Modifier,
    text: String,
    bold: Boolean = false,
    color: Color = Dark,
    style: TextStyle = customTypography.bodyLarge,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = style.copy(
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
            color = color
        ),
        overflow = overflow
    )
}

@Preview
@Composable
private fun JobTextPreview() {
    JobText(text = "Text Message", color = White)
}