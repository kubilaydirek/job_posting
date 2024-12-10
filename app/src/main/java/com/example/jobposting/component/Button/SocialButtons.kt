package com.example.jobposting.component.Button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobposting.R
import com.example.jobposting.ui.theme.Secondary

@Composable
fun SocialButton(modifier: Modifier = Modifier,painter: Painter) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable {  }
            .size(50.dp)
            .background(Secondary),
        contentAlignment = Alignment.Center,
        ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun SocialButtonPreviewFacebook() {
    SocialButton(painter = painterResource(R.drawable.facebook_icon))
}


@Preview
@Composable
private fun SocialButtonPreviewInstagram() {
    SocialButton(painter = painterResource(R.drawable.instagram))
}

@Preview
@Composable
private fun SocialButtonPreviewGoogle() {
    SocialButton(painter = painterResource(R.drawable.google))
}