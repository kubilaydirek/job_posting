package com.example.jobposting.ui.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobposting.ui.component.text.JobText
import com.example.jobposting.ui.theme.Dark
import com.example.jobposting.ui.theme.Primary
import com.example.jobposting.ui.theme.White
import com.example.jobposting.ui.theme.customTypography

@Composable
fun JobOutlineButton(modifier: Modifier = Modifier, onClick: () -> Unit,text : String) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        border = BorderStroke(width = 2.dp, color = Primary),
        shape = RoundedCornerShape(16.dp),
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(containerColor = White)
    ) {
        JobText(text = text, bold = true, style = customTypography.headlineSmall, color = Dark)
    }
}

@Preview
@Composable
private fun JobOutlineButtonPreview() {
    JobOutlineButton(text = "Get Started", onClick = {})
}