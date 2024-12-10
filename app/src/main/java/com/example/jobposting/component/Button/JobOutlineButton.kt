package com.example.jobposting.component.Button

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
import com.example.jobposting.component.JobText
import com.example.jobposting.ui.theme.Primary
import com.example.jobposting.ui.theme.White

@Composable
fun JobOutlineButton(modifier: Modifier = Modifier, onClick: () -> Unit,text : String) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        border = BorderStroke(width = 3.dp, color = Primary),
        shape = RoundedCornerShape(12.dp),
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(containerColor = White)
    ) {
        JobText(text = text, bold = true)
    }
}

@Preview
@Composable
private fun JobOutlineButtonPreview() {
    JobOutlineButton(text = "Get Started", onClick = {})
}