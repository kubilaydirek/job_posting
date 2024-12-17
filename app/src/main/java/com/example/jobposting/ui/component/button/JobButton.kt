package com.example.jobposting.ui.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.theme.Primary
import com.example.jobposting.ui.theme.White
import com.example.jobposting.ui.theme.customTypography

@Composable
fun JobButton(modifier: Modifier = Modifier, onclick: () -> Unit, buttonText: String) {
    Button(
        onClick = { onclick.invoke() }, modifier = modifier
            .fillMaxWidth()
            .height(56.dp), shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Primary)
    ) {
        JobText(text = buttonText, color = White, bold = true, style = customTypography.titleSmall)
    }
}

@Preview
@Composable
private fun JobButtonPreview() {
    JobButton(onclick = {}, buttonText = "Get Started")
}