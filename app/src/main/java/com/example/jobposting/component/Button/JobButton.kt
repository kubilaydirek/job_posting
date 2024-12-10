package com.example.jobposting.component.Button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobposting.component.JobText
import com.example.jobposting.ui.theme.Primary
import com.example.jobposting.ui.theme.White

@Composable
fun JobButton(modifier: Modifier = Modifier, onclick: () -> Unit) {
    Button(
        onClick = { onclick.invoke() }, modifier = modifier
            .fillMaxWidth()
            .height(40.dp), shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Primary)
    ) {
        JobText(text ="Get Started", color = White, bold = true )
    }
}

@Preview
@Composable
private fun JobButtonPreview() {
    JobButton(onclick = {})
}